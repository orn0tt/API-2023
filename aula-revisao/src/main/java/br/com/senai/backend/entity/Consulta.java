package br.com.senai.backend.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consulta")
	private Long idConsulta;

	private LocalDate dataConsulta;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	@OneToMany(mappedBy = "consulta")
	private List<Procedimentos> listaProcedimentos = new ArrayList<>();

	@Transient
	private double totalGeralConsulta = 0.0;

	public Long getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Procedimentos> getListaProcedimentos() {
		return listaProcedimentos;
	}

	@Override
	public String toString() {
		return "Consulta [idConsulta=" + idConsulta + ", dataConsulta=" + dataConsulta + ", paciente=" + paciente
				+ ", listaProcedimentos=" + listaProcedimentos + ", totalGeralConsulta=" + totalGeralConsulta + "]";
	}

	public Double getTotalGeralConsulta() {
		for (Procedimentos procedimentos : listaProcedimentos) {
			this.totalGeralConsulta += procedimentos.getSubTotal();
		}
		return this.totalGeralConsulta;
	}

	public void setTotalGeralConsulta(Double totalGeralConsulta) {
		this.totalGeralConsulta = totalGeralConsulta;
	}

}
