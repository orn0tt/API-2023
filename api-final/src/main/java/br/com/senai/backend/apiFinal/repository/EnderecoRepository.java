package br.com.senai.backend.apiFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.apiFinal.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Endereco findByCep(String cep);
}