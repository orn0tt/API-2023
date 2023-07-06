package br.com.senai.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.senai.backend.exception.EnumValidationException;

public enum Status {

	AGUARDANDO, EmATENDIMENTO, ATENDIDO;

	@JsonCreator
	public static Status verificarStatus(String tipo) throws EnumValidationException {
		for (Status s : Status.values()) {
			if (tipo.equals(s.name())) {
				return s;
			}
		}

		throw new EnumValidationException("Status preenchido incorretamente.");
	}
}