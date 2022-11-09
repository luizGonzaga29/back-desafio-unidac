package com.grupowl.desafiounidac.excecoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManipuladorExcecoes {

	@ExceptionHandler(CpfNaoEncontradoExcecao.class)
	public ResponseEntity<ErroPadrao> cpfNaoEncontrado(CpfNaoEncontradoExcecao e, HttpServletRequest request) {
		String error = "Cpf não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(CpfJaCadastradoExcecao.class)
	public ResponseEntity<ErroPadrao> cpfJaCadastrado(CpfJaCadastradoExcecao e, HttpServletRequest request) {
		String error = "Cpf já cadastrado!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(CampoVazioExcecoes.class)
	public ResponseEntity<ErroPadrao> campoVazio(CampoVazioExcecoes e, HttpServletRequest request) {
		String error = "Algum campo está faltando!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(CpfInvalidoExcecao.class)
	public ResponseEntity<ErroPadrao> CpfInvalido(CpfInvalidoExcecao e, HttpServletRequest request) {
		String error = "Cpf inválido!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(CampoVazioLancheExcecoes.class)
	public ResponseEntity<ErroPadrao> CampoVazioLanche(CampoVazioLancheExcecoes e, HttpServletRequest request) {
		String error = "Não pode haver lanche em branco!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(NomeRepetidoLancheExcecoes.class)
	public ResponseEntity<ErroPadrao> NomeRepetidoLanche(NomeRepetidoLancheExcecoes e, HttpServletRequest request) {
		String error = "Não é permitido trazer o mesmo tipo de lanche!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
