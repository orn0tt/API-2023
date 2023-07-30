package br.com.senai.backend.apiFinal.dto;

import br.com.senai.backend.apiFinal.entity.Cliente;

public class ClienteInserirDTO {

	private String nome;
	private String email;
	private String cep;
	private String cpf;

	public ClienteInserirDTO() {
		
	}

	public ClienteInserirDTO(Cliente cliente) {
		
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
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

	public String getCep() {
		
		return cep;
	}

	public void setCep(String cep) {
		
		this.cep = cep;
	}

	public String getCpf() {
		
		return cpf;
	}

	public void setCpf(String cpf) {
		
		this.cpf = cpf;
	}
}