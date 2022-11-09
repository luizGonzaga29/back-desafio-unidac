package com.grupowl.desafiounidac.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupowl.desafiounidac.model.Colaborador;
import com.grupowl.desafiounidac.model.Lanche;
import com.grupowl.desafiounidac.repository.LancheRepository;

@Service
public class ValidacaoLanches {

	@Autowired
	private LancheRepository lancheRepository;

	public ValidacaoLanches() {}
	
	public boolean validarCamposLanche(Colaborador col) {
		
		boolean validacaoCampos = false;
		for (Lanche lan : col.getLanches()) {
			if (lan.getNome().trim().equals("")) {
				validacaoCampos = true;
				break;
			}
		}
		return validacaoCampos;
	}

	public boolean verificarLanchesRepetidos(Colaborador col) {
		
		boolean verificaNome = false;
		int contador_lanche = 0;
		int contador_lanche_cadastrado = 0;
		for (Lanche lan : col.getLanches()) {
			contador_lanche = verificaLancheMesmoColaborador(col, lan.getNome());
			contador_lanche_cadastrado = verificaLancheCadastrado(lan.getNome());
			if (contador_lanche > 1 || contador_lanche_cadastrado > 1) {
				verificaNome = true;
				break;
			}
			contador_lanche = 0;
			contador_lanche_cadastrado = 0;
		}

		return verificaNome;
	}

	private int verificaLancheMesmoColaborador(Colaborador col, String nome) {

		int contador = 0;
		for (Lanche lanche : col.getLanches()) {
			if (nome.equalsIgnoreCase(lanche.getNome())) {
				contador++;
			}
		}
		return contador;
	}

	private int verificaLancheCadastrado(String nome) {
		
		int contador = 0;
		try {
			Lanche lanche = lancheRepository.buscarLanchePorNome(nome);
			if (lanche != null)
				contador = 2;
		}catch (Exception e) {
			return contador;
		}
		return contador;
	}
}
