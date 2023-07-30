package br.com.senai.backend.dto;

import br.com.senai.backend.entity.Procedimentos;

public class ProcedimentosResponseDTO {

	private String nomeExame;

	private Integer quantidade;

	private Double valorProcedimento;

	private Double subTotal;

	public ProcedimentosResponseDTO() {
	}

	public ProcedimentosResponseDTO(Procedimentos procedimentos) {
		this.nomeExame = procedimentos.getExame().getTipo();
		this.quantidade = procedimentos.getQuantidade();
		this.valorProcedimento = procedimentos.getValorProcedimento();
		this.subTotal = procedimentos.getSubTotal();
	}

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
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

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

}
