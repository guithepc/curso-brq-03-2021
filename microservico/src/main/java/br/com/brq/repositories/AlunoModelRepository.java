package br.com.brq.repositories;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.brq.models.AlunoModel;

@Repository
public interface AlunoModelRepository extends JpaRepository<AlunoModel, Integer> {

	@Modifying
	@Transactional
	@Query(value="DELETE FROM aluno where matricula = :aluno", nativeQuery = true)
	void delete(int aluno);
	
	
	List<AlunoModel> findByNomeContains(String nomealuno);
}