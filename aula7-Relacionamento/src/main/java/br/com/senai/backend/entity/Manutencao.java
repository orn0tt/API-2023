package br.com.senai.backend.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Manutencao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_manutencao")
	private Long id;

	@Column(name = "data_entrada")
	private LocalDate dataEntrada;

	@Column(name = "data_saida")
	private LocalDate dataSaida;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_veiculo")
	private Veiculo veiculo;

	@ManyToMany
	@JoinTable(name = "manutencao_servico", joinColumns = @JoinColumn(name = "id_manutencao"), inverseJoinColumns = @JoinColumn(name = "id_servico"))
	private List<Servico> servicos;

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public LocalDate getDataEntrada() {

		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {

		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {

		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {

		this.dataSaida = dataSaida;
	}

	public Veiculo getVeiculo() {

		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {

		this.veiculo = veiculo;
	}

	public List<Servico> getServicos() {

		return servicos;
	}
}