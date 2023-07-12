package br.com.senai.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.dto.FornecedorListarDTO;
import br.com.senai.backend.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping("{cnpj}")
	public ResponseEntity<FornecedorListarDTO> listar(@PathVariable String cnpj) {

		return ResponseEntity.ok(fornecedorService.buscar(cnpj));
	}
}