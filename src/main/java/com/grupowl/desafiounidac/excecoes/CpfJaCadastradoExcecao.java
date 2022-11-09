package com.grupowl.desafiounidac.excecoes;

public class CpfJaCadastradoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CpfJaCadastradoExcecao(Object cpf) {
		super("Cpf já cadastrado. cpf : " + cpf);
	}
}
