package br.com.senai.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.senai.backend.dto.ClienteResponseDTO;
import br.com.senai.backend.entity.Cliente;
import br.com.senai.backend.entity.Foto;
import br.com.senai.backend.service.ClienteService;
import br.com.senai.backend.service.FotoService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private FotoService fotoService;

	@GetMapping
	public ResponseEntity<List<ClienteResponseDTO>> listar() {

		return ResponseEntity.ok(clienteService.listar());
	}

	@GetMapping("/{id}/foto")
	public ResponseEntity<byte[]> buscarPorFoto(@PathVariable Long id) {

		Foto foto = fotoService.buscarFoto(id);

		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", foto.getTipo());
		headers.add("content-lenght", String.valueOf(foto.getDados().length));

		return new ResponseEntity<byte[]>(foto.getDados(), headers, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Long id) {

		return ResponseEntity.ok(clienteService.buscar(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponseDTO inserir(@RequestPart Cliente cliente, @RequestParam MultipartFile file)
			throws IOException {

		return clienteService.inserir(cliente, file);
	}
}