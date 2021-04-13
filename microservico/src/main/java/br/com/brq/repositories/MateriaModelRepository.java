package br.com.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.brq.models.MateriaModel;

public interface MateriaModelRepository extends JpaRepository<MateriaModel, Integer>{
	
	//SELECT * FROM material where nome = <nome>
	@Query (value = "SELECT * FROM materia where nome like %:nome%", nativeQuery = true)
	List<MateriaModel> findByNomeContains(String nome);
}
