package br.com.senai.backend.apiFinal.dto;

import br.com.senai.backend.apiFinal.entity.ItemPedido;

public class ItemPedidoDTO {

	private Integer quantidade;
	private Double valor;
	private Double subTotal;

	public ItemPedidoDTO() {

	}

	public ItemPedidoDTO(ItemPedido itemPedido) {

		this.quantidade = itemPedido.getQuantidade();
		this.valor = itemPedido.getValor();
		this.subTotal = itemPedido.getSubTotal();
	}

	public Integer getQuantidade() {

		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {

		this.quantidade = quantidade;
	}

	public Double getValor() {

		return valor;
	}

	public void setValor(Double valor) {

		this.valor = valor;
	}

	public Double getSubTotal() {

		return subTotal;
	}

	public void setSubTotal(Double subTotal) {

		this.subTotal = subTotal;
	}
}