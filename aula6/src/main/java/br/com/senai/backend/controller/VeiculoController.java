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

import br.com.senai.backend.entity.Veiculo;
import br.com.senai.backend.repository.VeiculoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	@Autowired
	private VeiculoRepository veiculoRepository;

	@PostMapping
	public ResponseEntity<Veiculo> inserir(@Valid @RequestBody Veiculo veiculo) {

		veiculo = veiculoRepository.save(veiculo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(veiculo.getId())
				.toUri();

		return ResponseEntity.created(uri).body(veiculo);
	}

	@GetMapping
	public ResponseEntity<List<Veiculo>> listar() {

		List<Veiculo> veiculos = veiculoRepository.findAll();

		return ResponseEntity.ok(veiculos);
	}
}