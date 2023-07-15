package br.com.senai.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.dto.LancamentoVendasMostrarDTO;
import br.com.senai.backend.entity.LancamentoVendas;
import br.com.senai.backend.service.LancamentoService;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;

	@GetMapping("{id}")
	public ResponseEntity<LancamentoVendasMostrarDTO> listarPorId(@PathVariable Long id) {

		return ResponseEntity.ok(lancamentoService.listarPorId(id));
	}

	@GetMapping("/page")
	public ResponseEntity<Page<LancamentoVendasMostrarDTO>> listarPorPagina(Pageable pageable) {

		return ResponseEntity.ok(lancamentoService.listarPorPagina(pageable));
	}

	@PostMapping
	public ResponseEntity<LancamentoVendasMostrarDTO> inserirLancamento(
			@RequestBody LancamentoVendas lancamentoVendas) {

		return ResponseEntity.ok(lancamentoService.inserirLancamento(lancamentoVendas));
	}
}