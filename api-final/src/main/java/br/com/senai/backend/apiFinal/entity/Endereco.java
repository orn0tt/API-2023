package br.com.senai.backend.apiFinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long idEndereco;

	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	private Long ibge;

	@Transient
	private String obs;

	public Long getIdEndereco() {

		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {

		this.idEndereco = idEndereco;
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

	public Long getIbge() {

		return ibge;
	}

	public void setIbge(Long ibge) {

		this.ibge = ibge;
	}

	public String getObs() {

		return obs;
	}

	public void setObs(String obs) {

		this.obs = obs;
	}
}