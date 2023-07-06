package br.com.senai.backend.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.senai.backend.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consulta")
	private Long id;

	//@NotBlank(message = "A data não pode estar nula.")
	@Column(name = "data_consulta", nullable = false)
	private LocalDate dataConsulta;

	//@NotBlank(message = "A hora não pode estar nula.")
	@Column(name = "hora_consulta", nullable = false)
	private LocalTime horaConsulta;

	@Enumerated(EnumType.STRING)
	private Status status;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "codigo_paciente")
	private Paciente paciente;

	@OneToOne
	@JoinColumn(name = "crm_medico")
	private Medico medico;

	public LocalDate getDataConsulta() {

		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {

		this.dataConsulta = dataConsulta;
	}

	public LocalTime getHoraConsulta() {

		return horaConsulta;
	}

	public void setHoraConsulta(LocalTime horaConsulta) {

		this.horaConsulta = horaConsulta;
	}

	public Status getStatus() {

		return status;
	}

	public void setStatus(Status status) {

		this.status = status;
	}

	public Paciente getPaciente() {

		return paciente;
	}

	public void setPaciente(Paciente paciente) {

		this.paciente = paciente;
	}

	public Medico getMedico() {

		return medico;
	}

	public void setMedico(Medico medico) {

		this.medico = medico;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}
}