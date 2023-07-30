package br.com.senai.backend.apiFinal.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;

	@Column(length = 60, nullable = false)
	private String nome;

	@Column(length = 40, nullable = false)
	private String email;

	@Column(length = 11)
	private String cpf;

	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@Override
	public String toString() {

		return "Codigo:" + idCliente + "\n Nome:" + nome + "\n Email:" + email;
	}

	public Long getIdCliente() {

		return idCliente;
	}

	public void setIdCliente(Long idCliente) {

		this.idCliente = idCliente;
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

	public Endereco getEndereco() {

		return endereco;
	}

	public void setEndereco(Endereco endereco) {

		this.endereco = endereco;
	}

	public String getCpf() {

		return cpf;
	}

	public void setCpf(String cpf) {

		this.cpf = cpf;
	}
}