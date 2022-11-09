package com.grupowl.desafiounidac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupowl.desafiounidac.excecoes.CampoVazioExcecoes;
import com.grupowl.desafiounidac.excecoes.CampoVazioLancheExcecoes;
import com.grupowl.desafiounidac.excecoes.CpfInvalidoExcecao;
import com.grupowl.desafiounidac.excecoes.CpfJaCadastradoExcecao;
import com.grupowl.desafiounidac.excecoes.CpfNaoEncontradoExcecao;
import com.grupowl.desafiounidac.excecoes.NomeRepetidoLancheExcecoes;
import com.grupowl.desafiounidac.model.Colaborador;
import com.grupowl.desafiounidac.repository.ColaboradorRepository;
import com.grupowl.desafiounidac.validacoes.ValidacaoColaborador;
import com.grupowl.desafiounidac.validacoes.ValidacaoLanches;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repo;
	
	@Autowired
	private LancheService lancheService;
	
	@Autowired
	private ValidacaoLanches validarLanche;
	
	public List<Colaborador> buscarTodosColaboradores(){
		return repo.buscarTodosColaboradores();
	}
	
	public Colaborador inserirColaborador(Colaborador colaborador) {
		
		if(ValidacaoColaborador.validarCamposColaborador(colaborador)) 
			throw new CampoVazioExcecoes();
		if(!ValidacaoColaborador.isValidCPF(colaborador.getCpf()))
			throw new CpfInvalidoExcecao(colaborador.getCpf());
		if(repo.buscarColaboradorPorCpf(colaborador.getCpf()) != null)
			throw new CpfJaCadastradoExcecao(colaborador.getCpf());
		if(colaborador.getLanches().size() < 1 || validarLanche.validarCamposLanche(colaborador))
			throw new CampoVazioLancheExcecoes();
		if(validarLanche.verificarLanchesRepetidos(colaborador))
			throw new NomeRepetidoLancheExcecoes();
		
		colaborador = repo.save(colaborador);
		lancheService.inserirLanche(colaborador);
		return colaborador;
	}
	
	public void atualizarColaborador(Colaborador colaborador) {
		
		if(ValidacaoColaborador.validarCamposColaborador(colaborador)) 
			throw new CampoVazioExcecoes();
		if(!ValidacaoColaborador.isValidCPF(colaborador.getCpf()))
			throw new CpfInvalidoExcecao(colaborador.getCpf());
		
		Colaborador col = repo.buscarColaboradorPorId(colaborador.getId());
				
		if(repo.buscarColaboradorPorCpf(colaborador.getCpf()) != null && !col.getCpf().equals(colaborador.getCpf()))
			throw new CpfJaCadastradoExcecao(colaborador.getCpf());
		repo.atualizarColaborador(colaborador.getId(), colaborador.getCpf(), colaborador.getNome());
	}
	
	public void deletarColaborador(Long id) {
		lancheService.deletarLanches(id);
		repo.deletarColaborador(id);
	}
	
	public Colaborador buscarColaboradorPorCpf(String cpf) {
		Colaborador col = repo.buscarColaboradorPorCpf(cpf);
		if(col == null)	throw new CpfNaoEncontradoExcecao(cpf);
		return col;
	}
}
