package br.com.senai.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.backend.dto.ConsultaResponseDTO;
import br.com.senai.backend.entity.Consulta;
import br.com.senai.backend.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	ConsultaRepository consultaRepository;

	public ConsultaResponseDTO buscarConsulta(Long id) {
		System.out.println("teste service");
		Optional<Consulta> consulta = consultaRepository.findById(id);
		System.out.println(consulta.get());
	//	System.out.println("Total Geral:"+consulta.get().getTotalGeralConsulta());
		return new ConsultaResponseDTO(consulta.get());
	}

	public List<ConsultaResponseDTO> listarTodas() {
		List<Consulta> consultas = consultaRepository.findAll();
		return consultas.stream().
				map(c-> new ConsultaResponseDTO(c)).collect(Collectors.toList());
	}
}
