package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Evento;
import java.util.List;
import java.time.LocalDate;

public interface EventoRepository extends JpaRepository<Evento, Long> {

	Evento findByDescricao(String descricao);


}
