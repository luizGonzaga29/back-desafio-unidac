package com.grupowl.desafiounidac.excecoes;

public class NomeRepetidoLancheExcecoes extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NomeRepetidoLancheExcecoes() {
		super("Você preencheu algum lanche errado!");
	}
}
