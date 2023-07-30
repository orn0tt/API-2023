package br.com.senai.backend.dto;

import java.util.List;

public class ConsultaRequestDTO {
	private Long idConsulta;
	private Long idPaciente;
	private List<ProcedimentosRequestDTO> procedimentos;

	public Long getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public List<ProcedimentosRequestDTO> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<ProcedimentosRequestDTO> procedimentos) {
		this.procedimentos = procedimentos;
	}

}
