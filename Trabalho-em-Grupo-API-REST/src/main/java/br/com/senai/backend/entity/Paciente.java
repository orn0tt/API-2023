package br.com.senai.backend.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_paciente")
	private Long codigoPaciente;

	@NotBlank(message = "O nome está nulo ou em branco.")
	@Size(max = 60, message = "Nome inválido pois contém muitos caracteres.")
	@Column(name = "nome_paciente", nullable = false, length = 60)
	private String nome;

	@Email(message = "Endereço de email digitado inválido.")
	@Column(name = "email_paciente", nullable = false)
	private String email;

	@NotBlank(message = "Número de telefone nulo ou em branco.")
	@Size(max = 11, message = "O número digitado é inválido")
	@Column(name = "telefone_paciente", nullable = false, length = 11)
	private String telefone;

	@JsonManagedReference
	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas;

	public Long getCodigoPaciente() {

		return codigoPaciente;
	}

	public void setCodigoPaciente(Long codigoPaciente) {

		this.codigoPaciente = codigoPaciente;
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

	public List<Consulta> getConsultas() {

		return consultas;
	}
}