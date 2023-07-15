package br.com.senai.backend.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.dto.FuncionarioDTO;
import br.com.senai.backend.entity.Funcionario;
import br.com.senai.backend.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping
	public ResponseEntity<List<FuncionarioDTO>> listar() {

		return ResponseEntity.ok(funcionarioService.listar());
	}

	@GetMapping("/page")
	public ResponseEntity<Page<FuncionarioDTO>> listarPorPagina(
			@PageableDefault(size = 10, sort = "dataNascimento", direction = Direction.DESC, page = 1) Pageable pageable) {

		return ResponseEntity.ok(funcionarioService.listarPorPagina(pageable));
	}

	@GetMapping("/salario")
	public ResponseEntity<Page<Funcionario>> listarPorSalario(@RequestParam(defaultValue = "0") Double valorMinimo,
			@RequestParam(defaultValue = "20000") Double valorMaximo, Pageable pageable) {

		return ResponseEntity.ok(funcionarioService.listarPorSalario(valorMinimo, valorMaximo, pageable));
	}

	@GetMapping("/id")
	public ResponseEntity<Page<Funcionario>> listarPorSalario(Pageable pageable) {

		return ResponseEntity.ok(funcionarioService.listarPorId(pageable));
	}

	@GetMapping("/nome")
	public ResponseEntity<Page<Funcionario>> listarPorParteDoNome(@RequestParam(defaultValue = "") String paramNome,
			Pageable pageable) {

		return ResponseEntity.ok(funcionarioService.listarPorParteDoNome(paramNome, pageable));
	}

	@GetMapping("/data")
	public ResponseEntity<Page<Funcionario>> listarPorData(@RequestParam String paramData, Pageable pageable) {

		LocalDate dataNascimento = LocalDate.parse(paramData, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		return ResponseEntity.ok(funcionarioService.listarPorData(dataNascimento, pageable));
	}
}