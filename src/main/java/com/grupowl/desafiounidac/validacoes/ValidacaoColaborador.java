package com.grupowl.desafiounidac.validacoes;

import java.util.InputMismatchException;

import com.grupowl.desafiounidac.model.Colaborador;

public class ValidacaoColaborador {

	public static boolean validarCamposColaborador(Colaborador col) {
		boolean validacaoCampos = false;
		if (col.getNome().trim().equals("") || col.getCpf().trim().equals("")) {
			validacaoCampos = true;
		}
		return validacaoCampos;
	}

	public static boolean isValidCPF(String cpf) {

		if (cpf.equals("00000000000") ||
			cpf.equals("11111111111") ||
			cpf.equals("22222222222") ||
			cpf.equals("33333333333") ||
			cpf.equals("44444444444") ||
			cpf.equals("55555555555") ||
			cpf.equals("66666666666") ||
			cpf.equals("77777777777") ||
			cpf.equals("88888888888") ||
			cpf.equals("99999999999") ||
			(cpf.length() != 11) || (cpf == null))
			return false;

		char dig10, dig11;
		int soma, indice, resultado, num, peso;

		
		try {
			
			soma = 0;
			peso = 10;
			for (indice = 0; indice < 9; indice++) {
				
				num = (int) (cpf.charAt(indice) - 48);
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			resultado = 11 - (soma % 11);
			if ((resultado == 10) || (resultado == 11))
				dig10 = '0';
			else
				dig10 = (char) (resultado + 48); 

			soma = 0;
			peso = 11;
			for (indice = 0; indice < 10; indice++) {
				num = (int) (cpf.charAt(indice) - 48);
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			resultado = 11 - (soma % 11);
			if ((resultado == 10) || (resultado == 11))
				dig11 = '0';
			else
				dig11 = (char) (resultado + 48);
			
			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
}
