package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}