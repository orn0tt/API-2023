package br.com.senai.backend.apiFinal.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.backend.apiFinal.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Pedido {

	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	private LocalDate dataCriacao;
	private LocalDate dataEnvio;
	private LocalDate dataEntrega;
	private LocalTime horaCriacao;

	@Transient
	private double totalGeralPedido;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens = new ArrayList<>();

	public Status getStatus() {

		return status;
	}

	public void setStatus(Status status) {

		this.status = status;
	}

	public Long getIdPedido() {

		return idPedido;
	}

	public void setIdPedido(Long idPedido) {

		this.idPedido = idPedido;
	}

	public Cliente getCliente() {

		return cliente;
	}

	public void setCliente(Cliente cliente) {

		this.cliente = cliente;
	}

	public LocalDate getDataCriacao() {

		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {

		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataEnvio() {

		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {

		this.dataEnvio = dataEnvio;
	}

	public LocalDate getDataEntrega() {

		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {

		this.dataEntrega = dataEntrega;
	}

	public LocalTime getHoraCriacao() {

		return horaCriacao;
	}

	public void setHoraCriacao(LocalTime horaCriacao) {

		this.horaCriacao = horaCriacao;
	}

	public List<ItemPedido> getItens() {

		return itens;
	}

	public void setItens(List<ItemPedido> itens) {

		this.itens = itens;
	}

	public double getTotalGeralPedido() {

		double total = 0.0;

		for (ItemPedido item : itens) {

			total += item.getValor() * item.getQuantidade();
		}
		return total;
	}

	public void setTotalGeralPedido(double totalGeralPedido) {

		this.totalGeralPedido = totalGeralPedido;
	}
}