package br.com.senai.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senai.backend.entity.Usuario;

public class UsuarioListarDTO {

	@JsonIgnore
	private Long id;

	private String nome;

	private String email;

	public UsuarioListarDTO() {

	}

	public UsuarioListarDTO(Usuario usuario) {

		this.id = usuario.getIdUsuario();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
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