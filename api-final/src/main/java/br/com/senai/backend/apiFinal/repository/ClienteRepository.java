package br.com.senai.backend.apiFinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.apiFinal.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findByEmail(String email);

	Optional<Cliente> findByNome(String nome);

	Optional<Cliente> findById(Long idCliente);
}