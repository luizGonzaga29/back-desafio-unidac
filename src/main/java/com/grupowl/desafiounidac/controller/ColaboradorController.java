package com.grupowl.desafiounidac.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grupowl.desafiounidac.model.Colaborador;
import com.grupowl.desafiounidac.service.ColaboradorService;

@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping
	public ResponseEntity<List<Colaborador>> buscarTodosColaboradores(){
		List<Colaborador> listaColaborador = colaboradorService.buscarTodosColaboradores();
		return ResponseEntity.ok().body(listaColaborador);
	}
	@CrossOrigin
	@PostMapping(value="/post")
	public ResponseEntity<Colaborador> inserirColaborador(@RequestBody Colaborador colaborador){
		colaborador = colaboradorService.inserirColaborador(colaborador);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(colaborador.getId()).toUri();
		return ResponseEntity.created(uri).body(colaborador);
	}
	
	@PutMapping
	public ResponseEntity<Void> atualizarColaborador(@RequestBody Colaborador col){
		colaboradorService.atualizarColaborador(col);
		return ResponseEntity.ok().body(null);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deletarColaborador(@PathVariable Long id){
		colaboradorService.deletarColaborador(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<Colaborador> buscarColaboradorPorCpf(@PathVariable String cpf){
		Colaborador colaborador = colaboradorService.buscarColaboradorPorCpf(cpf);
		return ResponseEntity.ok().body(colaborador);
	}
}
