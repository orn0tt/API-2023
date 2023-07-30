package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {
	Exame findByTipo(String tipo);
}
