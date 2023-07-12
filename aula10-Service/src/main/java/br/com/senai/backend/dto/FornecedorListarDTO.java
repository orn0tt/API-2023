package br.com.senai.backend.dto;

import br.com.senai.backend.entity.Fornecedor;

public class FornecedorListarDTO {

	private String cnpj;
	private String tipo;
	private String nome;
	private String fantasia;

	public FornecedorListarDTO() {
		// TODO Auto-generated constructor stub
	}

	public FornecedorListarDTO(Fornecedor fornecedor) {
		super();
		this.cnpj = fornecedor.getCnpj();
		this.tipo = fornecedor.getTipo();
		this.nome = fornecedor.getNome();
		this.fantasia = fornecedor.getFantasia();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}
}