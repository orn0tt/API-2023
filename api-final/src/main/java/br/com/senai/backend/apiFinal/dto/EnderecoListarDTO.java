package br.com.senai.backend.apiFinal.dto;

import br.com.senai.backend.apiFinal.entity.Endereco;

public class EnderecoListarDTO {

	private Long id;
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;

	public EnderecoListarDTO() {

	}

	public EnderecoListarDTO(Endereco endereco) {

		this.id = endereco.getIdEndereco();
		this.cep = endereco.getCep();
		this.logradouro = endereco.getLogradouro();
		this.bairro = endereco.getBairro();
		this.localidade = endereco.getLocalidade();
		this.uf = endereco.getUf();
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getCep() {

		return cep;
	}

	public void setCep(String cep) {

		this.cep = cep;
	}

	public String getLogradouro() {

		return logradouro;
	}

	public void setLogradouro(String logradouro) {

		this.logradouro = logradouro;
	}

	public String getBairro() {

		return bairro;
	}

	public void setBairro(String bairro) {

		this.bairro = bairro;
	}

	public String getLocalidade() {

		return localidade;
	}

	public void setLocalidade(String localidade) {

		this.localidade = localidade;
	}

	public String getUf() {

		return uf;
	}

	public void setUf(String uf) {

		this.uf = uf;
	}
}