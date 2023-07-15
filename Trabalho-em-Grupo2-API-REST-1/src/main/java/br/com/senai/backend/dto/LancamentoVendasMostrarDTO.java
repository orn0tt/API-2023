package br.com.senai.backend.dto;

import java.time.LocalDate;

import br.com.senai.backend.entity.LancamentoVendas;

public class LancamentoVendasMostrarDTO {

	private LocalDate dataVenda;
	private Double valorVenda;
	private String nomeVendedor;

	public LancamentoVendasMostrarDTO() {
		// TODO Auto-generated constructor stub
	}

	public LancamentoVendasMostrarDTO(LancamentoVendas lancamentoVendas) {

		this.dataVenda = lancamentoVendas.getDataVenda();
		this.valorVenda = lancamentoVendas.getValorVenda();
		this.nomeVendedor = lancamentoVendas.getVendedor().getNome();
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
}