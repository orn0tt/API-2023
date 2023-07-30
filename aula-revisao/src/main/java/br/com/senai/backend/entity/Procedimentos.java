package br.com.senai.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Procedimentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_procedimentos")
	private Long idProcedimentos;

	private Integer quantidade;

	private Double valorProcedimento;

	@ManyToOne
	@JoinColumn(name = "id_consulta")
	private Consulta consulta;

	@ManyToOne
	@JoinColumn(name = "id_exame")
	private Exame exame;

	@Transient
	private Double subTotal;

	public Long getIdProcedimentos() {
		return idProcedimentos;
	}

	public void setIdProcedimentos(Long idProcedimentos) {
		this.idProcedimentos = idProcedimentos;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorProcedimento() {
		return valorProcedimento;
	}

	public void setValorProcedimento(Double valorProcedimento) {
		this.valorProcedimento = valorProcedimento;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Double getSubTotal() {
		return quantidade * valorProcedimento;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

}
