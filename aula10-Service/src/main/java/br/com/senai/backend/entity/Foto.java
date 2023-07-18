package br.com.senai.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_foto")
	private Long idFoto;

	private byte[] dados;
	private String nome;
	private String tipo;

	@OneToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Foto() {
		// TODO Auto-generated constructor stub
	}

	public Foto(Long idFoto, byte[] dados, String nome, String tipo, Cliente cliente) {
		super();
		this.idFoto = idFoto;
		this.dados = dados;
		this.nome = nome;
		this.tipo = tipo;
		this.cliente = cliente;
	}

	public Long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(Long idFoto) {
		this.idFoto = idFoto;
	}

	public byte[] getDados() {
		return dados;
	}

	public void setDados(byte[] dados) {
		this.dados = dados;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}