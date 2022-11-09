package com.grupowl.desafiounidac.excecoes;

public class CpfInvalidoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CpfInvalidoExcecao(String cpf) {
		super("Cpf inválido. Cpf : " + cpf);
	}
}
