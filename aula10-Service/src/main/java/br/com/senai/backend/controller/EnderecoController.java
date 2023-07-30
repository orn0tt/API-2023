package br.com.senai.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.dto.EnderecoListarDTO;
import br.com.senai.backend.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("{cep}")
	public ResponseEntity<EnderecoListarDTO> listar(@PathVariable String cep) {

		return ResponseEntity.ok(enderecoService.buscar(cep));
	}
}