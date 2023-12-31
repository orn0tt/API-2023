package br.com.senai.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veiculo")
	private Long id;

	@NotBlank(message = "Placa não preenchida!")
	@Size(max = 7, message = "Placa inválida!")
	@Column(nullable = false, length = 7)
	private String placa;

	@NotBlank(message = "Marca não preenchida")
	@Size(max = 30, message = "Tamanho máximo excedido de caracteres")
	@Column(nullable = false, length = 30)
	private String marca;

	@NotBlank(message = "Modelo não preenchida")
	@Size(max = 30, message = "Tamanho máximo excedido de caracteres")
	@Column(nullable = false, length = 30)
	private String modelo;

	@Embedded
	private Caracteristica caracteristica;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}
}