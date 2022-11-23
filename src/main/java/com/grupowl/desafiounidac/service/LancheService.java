package com.grupowl.desafiounidac.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupowl.desafiounidac.excecoes.LancheVazioExcecoes;
import com.grupowl.desafiounidac.model.Colaborador;
import com.grupowl.desafiounidac.model.Lanche;
import com.grupowl.desafiounidac.repository.LancheRepository;

@Service
public class LancheService {

	@Autowired
	private LancheRepository repo;
	
	public List<Lanche> inserirLanche(Colaborador colaborador) {
		List<Lanche> listaLanche = new ArrayList<>();
		for(Lanche lanche : colaborador.getLanches()) {
			Lanche lan = new Lanche();
			lan.setNome(lanche.getNome());
			lan.setColaborador(colaborador);
			listaLanche.add(lan);
		}
		
		return repo.saveAll(listaLanche);
	}
	
	public List<Lanche> buscarLanchesPorColaborador(Long id){
		return repo.buscarLanchePorColaborador(id);
	}
	
	public void deletarLanches(Long id) {
		repo.deletarLanche(id);
	}

	public Lanche buscarLanchePorNome(String nome) {
		
		return repo.buscarLanchePorNome(nome);
	}
	
	public List<Lanche> buscarTodosLanches(){
		List<Lanche> lista = repo.buscarTodosLanches();
		if(lista == null) throw new LancheVazioExcecoes();
		return repo.buscarTodosLanches();
	}
	
}
