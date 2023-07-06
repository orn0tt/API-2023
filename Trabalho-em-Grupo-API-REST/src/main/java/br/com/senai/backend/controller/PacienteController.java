package br.com.senai.backend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senai.backend.entity.Paciente;
import br.com.senai.backend.repository.PacienteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;

	@GetMapping
	@Operation(description = "Listar todos os pacientes", summary = "Listar pacientes")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Página não encontrada"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	public ResponseEntity<List<Paciente>> listar() {

		List<Paciente> pacientes = pacienteRepository.findAll();
		return ResponseEntity.ok(pacientes);
	}

	@GetMapping("{id}")
	@Operation(description = "Buscar um paciente por ID", summary = "Buscar paciente")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Página não encontrada"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	public ResponseEntity<Paciente> buscar(@PathVariable Long id) {

		Optional<Paciente> paciente = pacienteRepository.findById(id);

		if (paciente.isPresent()) {

			return ResponseEntity.ok(paciente.get());
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Operation(description = "Inserir um novo paciente", summary = "Cadastro de paciente")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Página não encontrada"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Paciente> inserir(@Valid @RequestBody Paciente paciente) {

		paciente = pacienteRepository.save(paciente);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(paciente.getCodigoPaciente()).toUri();

		return ResponseEntity.created(uri).body(paciente);
	}

	@PutMapping("{id}")
	@Operation(description = "Alterar um paciente", summary = "Alteração de paciente")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Página não encontrada"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	public ResponseEntity<Paciente> alterar(@Valid @RequestBody Paciente paciente, @PathVariable Long id) {

		Optional<Paciente> pacienteA = pacienteRepository.findById(id);

		if (pacienteA.isPresent()) {

			//pacienteRepository.deleteById(id);

			paciente.setCodigoPaciente(id);

			pacienteRepository.save(paciente);

			return ResponseEntity.ok(pacienteRepository.findById(id).get());
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("{id}")
	@Operation(description = "Apagar um paciente", summary = "Remoção de paciente")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Página não encontrada"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	public ResponseEntity<Paciente> apagar(@PathVariable Long id) {

		Optional<Paciente> paciente = pacienteRepository.findById(id);

		if (paciente.isPresent()) {

			pacienteRepository.deleteById(id);

			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}