package br.com.senai.backend.apiFinal.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.senai.backend.apiFinal.entity.Pedido;

public class PedidoResponseDTO {

	private List<ItemPedidoDTO> dto;
	private double totalGeralPedido;

	public PedidoResponseDTO() {

	}

	public PedidoResponseDTO(Pedido pedido) {

		this.dto = pedido.getItens().stream().map(p -> new ItemPedidoDTO(p)).collect(Collectors.toList());
		this.totalGeralPedido = pedido.getTotalGeralPedido();
	}

	public List<ItemPedidoDTO> getDto() {

		return dto;
	}

	public void setDto(List<ItemPedidoDTO> dto) {

		this.dto = dto;
	}

	public double getTotalGeralPedido() {

		return totalGeralPedido;
	}

	public void setTotalGeralPedido(double totalGeralPedido) {

		this.totalGeralPedido = totalGeralPedido;
	}
}