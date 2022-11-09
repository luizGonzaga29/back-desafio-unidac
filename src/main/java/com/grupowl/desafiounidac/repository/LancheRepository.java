package com.grupowl.desafiounidac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupowl.desafiounidac.model.Lanche;

@Repository
public interface LancheRepository extends JpaRepository<Lanche, Long> {

	@Query(value = "SELECT * FROM tb_lanche", nativeQuery = true)
	public List<Lanche> buscarTodosLanches();
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Lanche SET nome = :nome WHERE id = :id")
	public void atualizarlanche(@Param("id") Long id, @Param("nome") String nome);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE from Lanche WHERE colaborador_id = :id")
	public void deletarLanche(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM tb_lanche WHERE id = :id", nativeQuery = true)
	public Lanche buscarLanchePorId(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM tb_lanche WHERE colaborador_id = :colaborador_id", nativeQuery = true)
	public List<Lanche> buscarLanchePorColaborador(@Param("colaborador_id") Long colaborador_id);
	
	@Query(value = "SELECT * FROM tb_lanche WHERE nome = :nome", nativeQuery = true)
	public Lanche buscarLanchePorNome(@Param("nome") String nome);
}
