package com.grupowl.desafiounidac.excecoes;

public class CpfNaoEncontradoExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CpfNaoEncontradoExcecao(Object cpf) {
		super("Cpf não cadastrado. cpf : " + cpf);
	}
}
