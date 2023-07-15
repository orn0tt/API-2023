package br.com.senai.backend.dto;

import java.time.LocalDate;

import br.com.senai.backend.entity.Funcionario;

public class FuncionarioDTO {

	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private Double salario;

	public FuncionarioDTO() {
		// TODO Auto-generated constructor stub
	}

	public FuncionarioDTO(Funcionario funcionario) {

		this.nome = funcionario.getNome();
		this.email = funcionario.getEmail();
		this.dataNascimento = funcionario.getDataNascimento();
		this.salario = funcionario.getSalario();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
}