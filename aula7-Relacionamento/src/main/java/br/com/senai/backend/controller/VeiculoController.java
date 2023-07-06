package br.com.senai.backend.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senai.backend.entity.Veiculo;
import br.com.senai.backend.repository.VeiculoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
@Tag(name = "Veículo", description = "Recursos do veículo")
public class VeiculoController {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@PostMapping
	@Operation(description = "Inserir um novo veículo", summary = "Cadastro de veículo")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Página não encontrada"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	public ResponseEntity<Veiculo> inserir(@Valid @RequestBody Veiculo veiculo) {

		veiculo = veiculoRepository.save(veiculo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(veiculo.getId())
				.toUri();

		return ResponseEntity.created(uri).body(veiculo);
	}

	@GetMapping
	@Operation(description = "Listar todos os veículos", summary = "Listar veículo")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Página não encontrada"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	public ResponseEntity<List<Veiculo>> listar() {

		List<Veiculo> veiculos = veiculoRepository.findAll();

		return ResponseEntity.ok(veiculos);
	}

	@GetMapping("{id}")
	@Operation(description = "Buscar um veículo por ID", summary = "Buscar veículo")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad Request"),
			@ApiResponse(responseCode = "404", description = "Página não encontrada"),
			@ApiResponse(responseCode = "500", description = "Erro no servidor") })
	public ResponseEntity<Veiculo> buscar(@PathVariable Long id) {

		Optional<Veiculo> veiculo = veiculoRepository.findById(id);

		if (veiculo.isPresent()) {

			return ResponseEntity.ok(veiculo.get());
		}

		return ResponseEntity.notFound().build();
	}
}