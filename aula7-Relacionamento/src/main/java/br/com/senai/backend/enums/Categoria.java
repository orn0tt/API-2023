package br.com.senai.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.senai.backend.exception.EnumValidationException;

public enum Categoria {

	HATCH, SEDAN, PICAPE, SUV, CONVERSIVEL, MINIVAN;

	@JsonCreator
	public static Categoria verificarCategoria(String tipo) throws EnumValidationException {
		for (Categoria c : Categoria.values()) {
			if (tipo.equals(c.name())) {
				return c;
			}
		}

		throw new EnumValidationException("Categoria preenchida incorretamente.");
	}
}