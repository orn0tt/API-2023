package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}