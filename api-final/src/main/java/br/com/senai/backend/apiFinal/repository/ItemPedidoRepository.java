package br.com.senai.backend.apiFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.apiFinal.entity.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

}