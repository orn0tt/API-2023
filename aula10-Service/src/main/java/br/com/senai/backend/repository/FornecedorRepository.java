package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

	Fornecedor findByCnpj(String cnpj);
}