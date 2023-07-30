package br.com.senai.backend.apiFinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.apiFinal.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByIdPedido(Long idPedido);
}