package br.com.senai.backend.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senai.backend.dto.UsuarioInserirDTO;
import br.com.senai.backend.dto.UsuarioListarDTO;
import br.com.senai.backend.exception.EmailException;
import br.com.senai.backend.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioListarDTO>> listarTodos() {

		return ResponseEntity.ok(usuarioService.listarTodos());
	}

	@PostMapping
	public ResponseEntity<UsuarioListarDTO> inserir(@RequestBody UsuarioInserirDTO dto) throws EmailException {

		UsuarioListarDTO usuarioListarDTO = usuarioService.inserirUsuario(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(usuarioListarDTO.getId()).toUri();

		return ResponseEntity.created(uri).body(usuarioListarDTO);
	}
}