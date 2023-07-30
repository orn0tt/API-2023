package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Consulta;
import java.util.List;
import java.time.LocalDate;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
	//List<Consulta> findByDataConsulta(LocalDate dataConsulta);
}
