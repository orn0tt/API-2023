package br.com.senai.backend.apiFinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.apiFinal.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	public Optional<Categoria> findById(Long id);

	public Optional<Categoria> findByNome(String nome);
}