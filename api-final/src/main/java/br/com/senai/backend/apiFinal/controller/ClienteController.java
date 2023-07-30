package br.com.senai.backend.apiFinal.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senai.backend.apiFinal.dto.ClienteInserirDTO;
import br.com.senai.backend.apiFinal.dto.ClienteListarDTO;
import br.com.senai.backend.apiFinal.entity.Cliente;
import br.com.senai.backend.apiFinal.exception.EmailException;
import br.com.senai.backend.apiFinal.exception.ResourceNotFoundException;
import br.com.senai.backend.apiFinal.repository.ClienteRepository;
import br.com.senai.backend.apiFinal.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ResponseEntity<List<ClienteListarDTO>> listarTodos() {

		return ResponseEntity.ok(clienteService.listarTodos());
	}

	@PostMapping
	public ResponseEntity<ClienteListarDTO> inserir(@RequestBody ClienteInserirDTO dto) throws EmailException {

		ClienteListarDTO clienteListarDTO = clienteService.inserirCliente(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(clienteListarDTO.getId()).toUri();

		return ResponseEntity.created(uri).body(clienteListarDTO);
	}

	// Listar Cliente por ID
	@GetMapping("{idCliente}")
	public ClienteListarDTO listarPorId(@PathVariable Long idCliente) {

		Optional<Cliente> cliente = clienteRepository.findById(idCliente);

		if (clienteRepository.findById(idCliente).isPresent()) {

			return new ClienteListarDTO(cliente.get());
		}
		throw new ResourceNotFoundException("Cliente nao encontrado!");
	}

	// Atualizar Cliente
	@PutMapping("{idCliente}")
	public Cliente atualizar(@RequestBody Cliente cliente, @PathVariable Long idCliente) {

		if (clienteRepository.findById(idCliente).isPresent()) {

			cliente.setIdCliente(idCliente);

			return cliente = clienteRepository.save(cliente);
		}

		return null;
	}
}