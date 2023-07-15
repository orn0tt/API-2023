package br.com.senai.backend.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING, columnDefinition = "")
@DiscriminatorValue("V")
@Table(name = "VENDEDOR")
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_vendedor")
	private Long codigoVendedor;

	@NotBlank(message = "O nome inserido está nulo ou vazio.")
	@Column(name = "nome_vendedor")
	private String nome;

	@Email(message = "O email inserido não é válido.")
	@Column(name = "email_vendedor")
	private String email;

	@DecimalMin(value = "1320.00", message = "O salário deve ser maior ou igual ao salário mínimo.")
	@Column(name = "salario_vendedor")
	private Double salario;

	@Column(insertable = false, updatable = false)
	private String tipo;

	@OneToMany()
	private Set<LancamentoVendas> lancamentosVendas = new HashSet<>();

	public Long getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(Long codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<LancamentoVendas> getLancamentosVendas() {
		return lancamentosVendas;
	}
}