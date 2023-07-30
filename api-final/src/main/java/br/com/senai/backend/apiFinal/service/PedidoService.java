package br.com.senai.backend.apiFinal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.backend.apiFinal.dto.PedidoResponseDTO;
import br.com.senai.backend.apiFinal.entity.Pedido;
import br.com.senai.backend.apiFinal.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	public PedidoResponseDTO buscarPedido(Long id) {

		Optional<Pedido> pedido = pedidoRepository.findById(id);

		return new PedidoResponseDTO(pedido.get());
	}

	public List<PedidoResponseDTO> listarTodos() {

		List<Pedido> pedidos = pedidoRepository.findAll();

		return pedidos.stream().map(c -> new PedidoResponseDTO(c)).collect(Collectors.toList());
	}
}