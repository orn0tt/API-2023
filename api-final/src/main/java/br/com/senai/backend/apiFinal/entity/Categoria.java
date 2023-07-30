package br.com.senai.backend.apiFinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long idCategoria;

	private String nome;

	public Categoria() {

	}

	public Long getIdCategoria() {

		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {

		this.idCategoria = idCategoria;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}
}