package br.com.senai.backend.enums;

public enum Combustivel {
	
	ALCOOL(1, "ÁLCOOL"), GASOLINA(2, "GASOLINA"), FLEX(3, "FLEX"), DIESEL(4, "DIESEL");

	private Integer codigo;
	private String tipo;

	private Combustivel(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}
}