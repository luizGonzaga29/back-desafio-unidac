package com.grupowl.desafiounidac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupowl.desafiounidac.model.Lanche;
import com.grupowl.desafiounidac.service.LancheService;

@RestController
@CrossOrigin(origins = "https://marvelous-faloodeh-5f6c7e.netlify.app/")
@RequestMapping(value = "/lanche")
public class LancheController {

	@Autowired
	private LancheService lancheService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<Lanche>> buscarLanchesPorColaborador(@PathVariable Long id){
		List<Lanche> lista = lancheService.buscarLanchesPorColaborador(id);
		return ResponseEntity.ok().body(lista);
	}
	@GetMapping(value = "/nome/{nome}")
	public ResponseEntity<Lanche> buscarLanchePorNome(@PathVariable String nome){
		Lanche lanche = lancheService.buscarLanchePorNome(nome);
		return ResponseEntity.ok().body(lanche);
	}
	
	@GetMapping
	public ResponseEntity<List<Lanche>> buscarTodosLanches(){
		List<Lanche> lista = lancheService.buscarTodosLanches();
		return ResponseEntity.ok().body(lista);
	}
}
