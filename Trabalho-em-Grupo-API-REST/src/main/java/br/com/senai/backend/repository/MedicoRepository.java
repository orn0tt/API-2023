package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}