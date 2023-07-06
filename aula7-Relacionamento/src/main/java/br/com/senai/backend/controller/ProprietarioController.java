package br.com.senai.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.entity.Proprietario;
import br.com.senai.backend.repository.ProprietarioRepository;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Proprietario inserir(@RequestBody Proprietario proprietario) {

		return proprietarioRepository.save(proprietario);
	}

	@GetMapping
	public ResponseEntity<List<Proprietario>> listar() {

		List<Proprietario> proprietarios = proprietarioRepository.findAll();

		return ResponseEntity.ok(proprietarios);
	}
}
