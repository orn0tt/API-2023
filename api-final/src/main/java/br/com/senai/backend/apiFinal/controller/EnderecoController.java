package br.com.senai.backend.apiFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.apiFinal.dto.EnderecoListarDTO;
import br.com.senai.backend.apiFinal.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping("{cep}")
	public ResponseEntity<EnderecoListarDTO> listar(@PathVariable String cep) {

		return ResponseEntity.ok(enderecoService.buscar(cep));
	}
}