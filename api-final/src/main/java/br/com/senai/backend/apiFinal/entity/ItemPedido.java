package br.com.senai.backend.apiFinal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idItemPedido;

	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

	private Integer quantidade;
	private Double valor;

	@Transient
	private Double subTotal;

	public Pedido getPedido() {

		return pedido;
	}

	public void setPedido(Pedido pedido) {

		this.pedido = pedido;
	}

	public Produto getProduto() {

		return produto;
	}

	public void setProduto(Produto produto) {

		this.produto = produto;
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

	public Long getIdItemPedido() {

		return idItemPedido;
	}

	public void setIdItemPedido(Long idItemPedido) {

		this.idItemPedido = idItemPedido;
	}

	public Double getSubTotal() {

		return subTotal = quantidade * valor;
	}

	public void setSubTotal(Double subTotal) {

		this.subTotal = subTotal;
	}
}