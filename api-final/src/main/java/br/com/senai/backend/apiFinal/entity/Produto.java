package br.com.senai.backend.apiFinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idProduto;

	private Long codigoProduto;
	private String nome;
	private String descricao;
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Long getIdProduto() {

		return idProduto;
	}

	public void setIdProduto(Long idProduto) {

		this.idProduto = idProduto;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getDescricao() {

		return descricao;
	}

	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}

	public Categoria getCategoria() {

		return categoria;
	}

	public void setCategoria(Categoria categoria) {

		this.categoria = categoria;
	}

	public Long getCodigoProduto() {

		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {

		this.codigoProduto = codigoProduto;
	}

	public Double getValor() {

		return valor;
	}

	public void setValor(Double valor) {

		this.valor = valor;
	}
}