package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Manutencao;
import java.util.List;
import java.time.LocalDate;


public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{

	List<Manutencao> findByDataEntrada(LocalDate dataEntrada);
}