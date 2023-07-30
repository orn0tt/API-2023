package br.com.senai.backend.apiFinal.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senai.backend.apiFinal.entity.Produto;

public class ProdutoListarDTO {

	@JsonIgnore
	private Long id;

	private String nome;
	private Long codigo;

	public ProdutoListarDTO() {

	}

	public ProdutoListarDTO(Produto produto) {

		this.id = produto.getIdProduto();
		this.nome = produto.getNome();
		this.codigo = produto.getCodigoProduto();
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

	public Long getCodigo() {

		return codigo;
	}

	public void setEmail(Long codigo) {

		this.codigo = codigo;
	}
}