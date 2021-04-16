package br.com.brq.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brq.models.AlunoMateriaModel;

@Repository
public interface AlunoMateriaRepository extends JpaRepository<AlunoMateriaModel, Integer> {

	List<AlunoMateriaModel> findByAlunoId(int alunoId);
	
}