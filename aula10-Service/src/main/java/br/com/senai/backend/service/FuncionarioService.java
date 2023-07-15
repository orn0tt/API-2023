package br.com.senai.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.senai.backend.dto.FuncionarioDTO;
import br.com.senai.backend.entity.Funcionario;
import br.com.senai.backend.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public List<FuncionarioDTO> listar() {

		// Select * from funcionario
		List<Funcionario> funcionarios = funcionarioRepository.findAll();

		// Com stream e map
		return funcionarios.stream().map(f -> new FuncionarioDTO(f)).collect(Collectors.toList());
	}

	public Page<FuncionarioDTO> listarPorPagina(Pageable pageable) {

		Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);

		return funcionarios.map(f -> new FuncionarioDTO(f));
	}

	public Page<Funcionario> listarPorSalario(Double valorMinimo, Double valorMaximo, Pageable pageable) {

		// return funcionarioRepository.buscarSalario(valorMinimo, valorMaximo,
		// pageable);

		return funcionarioRepository.findBySalarioBetween(valorMinimo, valorMaximo, pageable);
	}

	public Page<Funcionario> listarPorId(Pageable pageable) {

		return funcionarioRepository.buscarPorId(pageable);
	}

	public Page<Funcionario> listarPorParteDoNome(String paramNome, Pageable pageable) {

		// return funcionarioRepository.buscarPorParteDoNome(paramNome, pageable);

		return funcionarioRepository.findByNomeContainingIgnoreCase(paramNome, pageable);
	}

	public Page<Funcionario> listarPorData(LocalDate paramData, Pageable pageable) {

		// return funcionarioRepository.buscarPorParteDoNome(paramNome, pageable);

		return funcionarioRepository.findByDataNascimentoGreaterThan(paramData, pageable);
	}
}