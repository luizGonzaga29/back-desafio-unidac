package com.grupowl.desafiounidac.excecoes;

public class CampoVazioExcecoes extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CampoVazioExcecoes() {
		super("Todos os campos devem ser preenchidos!");
	}
}
