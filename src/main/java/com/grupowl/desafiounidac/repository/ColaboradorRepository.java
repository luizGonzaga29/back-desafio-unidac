package com.grupowl.desafiounidac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grupowl.desafiounidac.model.Colaborador;

@Repository
public interface ColaboradorRepository extends CrudRepository<Colaborador, Long> {
	
	@Query(value = "SELECT * FROM tb_colaboradores", nativeQuery = true)
	public List<Colaborador> buscarTodosColaboradores();
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE Colaborador SET cpf = :cpf, nome = :nome WHERE id = :id")
	public void atualizarColaborador(@Param("id") Long id, @Param("cpf") String cpf, @Param("nome") String nome);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE from Colaborador WHERE id = :id")
	public void deletarColaborador(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM tb_colaboradores WHERE cpf = :cpf", nativeQuery = true)
	public Colaborador buscarColaboradorPorCpf(@Param("cpf") String cpf);
	
	@Query(value = "SELECT * FROM tb_colaboradores WHERE id = :id", nativeQuery = true)
	public Colaborador buscarColaboradorPorId(@Param("id") Long id);
}
