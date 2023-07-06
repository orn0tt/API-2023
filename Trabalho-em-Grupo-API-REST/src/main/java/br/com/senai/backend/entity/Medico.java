package br.com.senai.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Medico {

	@Id
	@NotNull(message = "O CRM está nulo ou em branco.")
	@Column(name = "crm_medico", nullable = false)
	private Long crm;

	@NotBlank(message = "O nome está nulo ou em branco.")
	@Size(max = 60, message = "Nome inválido pois contém muitos caracteres.")
	@Column(name = "nome_medico", nullable = false, length = 60)
	private String nome;

	@Email(message = "Endereço de email digitado inválido.")
	@Column(name = "email_medico", nullable = false)
	private String email;

	@NotBlank(message = "Número de telefone nulo ou em branco.")
	@Size(max = 11, message = "O número digitado é inválido")
	@Column(name = "telefone_medico", nullable = false, length = 11)
	private String telefone;

	public Long getCrm() {

		return crm;
	}

	public void setCrm(Long crm) {

		this.crm = crm;
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

	public String getTelefone() {

		return telefone;
	}

	public void setTelefone(String telefone) {

		this.telefone = telefone;
	}
}