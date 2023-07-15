package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.LancamentoVendas;

public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long> {

}