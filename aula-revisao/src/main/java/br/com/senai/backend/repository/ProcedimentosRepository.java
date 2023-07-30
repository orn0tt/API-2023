package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Procedimentos;

public interface ProcedimentosRepository extends JpaRepository<Procedimentos, Long> {

}
