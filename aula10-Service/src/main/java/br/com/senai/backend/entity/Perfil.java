package br.com.senai.backend.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil")
	private Long idPerfil;

	@Column(name = "nome_perfil", nullable = false, length = 40)
	private String nome;

	@OneToMany(mappedBy = "id.perfil")
	private Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();

	public Long getIdPerfil() {

		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {

		this.idPerfil = idPerfil;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public Set<UsuarioPerfil> getUsuarioPerfis() {

		return usuarioPerfis;
	}
}