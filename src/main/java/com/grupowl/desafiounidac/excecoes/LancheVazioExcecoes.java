package com.grupowl.desafiounidac.excecoes;

public class LancheVazioExcecoes extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LancheVazioExcecoes() {
		super("Não há lanches cadastrados");
	}
	
}
