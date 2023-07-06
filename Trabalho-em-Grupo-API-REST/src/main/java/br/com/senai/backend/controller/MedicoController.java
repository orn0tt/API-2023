package br.com.senai.backend.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senai.backend.entity.Medico;
import br.com.senai.backend.repository.MedicoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository medicoRepository;

	@GetMapping
	@Operation(description = "Listar todos os médicos.", summary = "Listar médicos.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Página não encontrada"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	public ResponseEntity<List<Medico>> listar() {

		List<Medico> medicos = medicoRepository.findAll();

		return ResponseEntity.ok(medicos);
	}

	@GetMapping("{id}")
	@Operation(description = "Buscar um médico por ID", summary = "Buscar médico")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Página não encontrada"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	public ResponseEntity<Medico> buscar(@PathVariable Long id) {

		Optional<Medico> medico = medicoRepository.findById(id);

		if (medico.isPresent()) {

			return ResponseEntity.ok(medico.get());
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Operation(description = "Inserir um novo médico", summary = "Cadastro de médico")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Página não encontrada"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Medico> inserir(@Valid @RequestBody Medico medico) {

		medico = medicoRepository.save(medico);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(medico.getCrm())
				.toUri();

		return ResponseEntity.created(uri).body(medico);
	}
}