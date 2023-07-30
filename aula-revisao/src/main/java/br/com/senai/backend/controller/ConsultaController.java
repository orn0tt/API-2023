package br.com.senai.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.dto.ConsultaResponseDTO;
import br.com.senai.backend.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	@GetMapping
	public ResponseEntity<List<ConsultaResponseDTO>> listar() {
		return ResponseEntity.ok(consultaService.listarTodas());
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaResponseDTO> buscar(@PathVariable Long id) {
		System.out.println("teste1");
		return ResponseEntity.ok(consultaService.buscarConsulta(id));
	}
	

}
