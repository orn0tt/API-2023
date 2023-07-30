package br.com.senai.backend.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.senai.backend.entity.Consulta;

public class ConsultaResponseDTO {

	private LocalDate dataConsulta;
	private String nomePaciente;

	private List<ProcedimentosResponseDTO> dto;
	private Double totalGeralConsulta;

	public ConsultaResponseDTO() {
	}

	public ConsultaResponseDTO(Consulta consulta) {
		this.dataConsulta = consulta.getDataConsulta();
		this.nomePaciente = consulta.getPaciente().getNome();
		this.dto = consulta.getListaProcedimentos().stream().map(p -> new ProcedimentosResponseDTO(p))
				.collect(Collectors.toList());
		this.totalGeralConsulta = consulta.getTotalGeralConsulta();
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public List<ProcedimentosResponseDTO> getDto() {
		return dto;
	}

	public void setDto(List<ProcedimentosResponseDTO> dto) {
		this.dto = dto;
	}

	public Double getTotalGeralConsulta() {
		return totalGeralConsulta;
	}

	public void setTotalGeralConsulta(Double totalGeralConsulta) {
		this.totalGeralConsulta = totalGeralConsulta;
	}

}
