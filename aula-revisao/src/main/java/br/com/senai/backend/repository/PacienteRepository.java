package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Paciente;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	// select * from paciente where nome = ?
	List<Paciente> findByNome(String nome);
}
