package com.grupowl.desafiounidac.excecoes;

public class CampoVazioLancheExcecoes extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CampoVazioLancheExcecoes() {
		super("Você deve informar ao menos um lanche!");
	}
}
