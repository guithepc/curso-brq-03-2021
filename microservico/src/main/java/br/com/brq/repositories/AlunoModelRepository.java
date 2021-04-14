package br.com.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.brq.models.AlunoModel;

public interface AlunoModelRepository extends JpaRepository<AlunoModel, Integer>{

	@Query (value = "SELECT * FROM aluno where nomealuno like %:nomealuno%", nativeQuery = true)
	List<AlunoModel> findByNomeContains(String nomealuno);
}
