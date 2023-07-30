package br.com.senai.backend.apiFinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.apiFinal.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public Optional<Produto> findByNome(String nome);
}