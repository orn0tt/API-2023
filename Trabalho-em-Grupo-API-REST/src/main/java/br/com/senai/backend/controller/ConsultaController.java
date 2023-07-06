package br.com.senai.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.entity.Consulta;
import br.com.senai.backend.repository.ConsultaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaRepository consultaRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Consulta inserir(@Valid @RequestBody Consulta consulta) {
		return consultaRepository.save(consulta);
	}

	@GetMapping
	public ResponseEntity<List<Consulta>> listar() {
		List<Consulta> consultas = consultaRepository.findAll();
		return ResponseEntity.ok(consultas);
	}

	@GetMapping("{id}")
	public ResponseEntity<Consulta> buscar(@PathVariable Long id) {

		Optional<Consulta> consulta = consultaRepository.findById(id);

		if (consulta.isPresent()) {

			return ResponseEntity.ok(consulta.get());
		}

		return ResponseEntity.notFound().build();
	}
}