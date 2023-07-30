package br.com.senai.backend.apiFinal.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senai.backend.apiFinal.entity.Cliente;

public class ClienteListarDTO {

	@JsonIgnore
	private Long id;

	private String nome;
	private String email;

	public ClienteListarDTO() {

	}

	public ClienteListarDTO(Cliente cliente) {

		this.id = cliente.getIdCliente();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
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
}