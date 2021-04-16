package br.com.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.brq.models.EscolaModel;


public interface EscolaModelRepository extends JpaRepository<EscolaModel, Integer>{
	@Query (value = "SELECT * FROM escola where nome like %:nome%", nativeQuery = true)
	
	
	List<EscolaModel> findByNomeContains(String nome);
}
