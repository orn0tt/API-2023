package br.com.senai.backend.apiFinal.enums;

public enum Status {

	ENVIADO(1, "ENVIADO"), ENTREGUE(2, "ENTREGUE"), AGUARDADO_PAGAMENTO(3, "AGUARDADO_PAGAMENTO");

	private Integer codigo;
	private String tipo;

	private Status(Integer codigo, String tipo) {

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