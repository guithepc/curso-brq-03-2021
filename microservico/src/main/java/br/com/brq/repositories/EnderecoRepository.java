package br.com.brq.repositories;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.brq.models.EnderecoModel;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Integer>  {

	@Modifying
	@Transactional
	@Query (value = "DELETE FROM endereco e where aluno_id = :aluno", nativeQuery = true)
	
	void deleteByAluno(@Param("aluno") int aluno);
	
	void deleteByAlunoMatriculaAluno(int id);
	
	List<EnderecoModel> findByLogradouroContains(String logradouro);
	
}