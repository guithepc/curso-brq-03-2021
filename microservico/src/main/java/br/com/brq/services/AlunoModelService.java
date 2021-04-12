package br.com.brq.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.models.AlunoModel;
import br.com.brq.repositories.AlunoModelRepository;

@Service
public class AlunoModelService {
	
	
	@Autowired
	private AlunoModelRepository alunoModelRepository;
	
	public List<AlunoModel> findAll(){
		return this.alunoModelRepository.findAll();
	}
	
	public AlunoModel findOne (Integer matriculaaluno) {
		return this.alunoModelRepository.findById(matriculaaluno).orElseThrow(() -> new RuntimeException ("Error### Aluno não encontrado"));
	}
	
	
	public AlunoModel save (AlunoModel novoAlunoModel) {
		return this.alunoModelRepository.save(novoAlunoModel);
	}
	
	public AlunoModel update (Integer matriculaaluno, AlunoModel alterarAlunoModel) {
		Optional<AlunoModel> opAlunoModel =  this.alunoModelRepository.findById(matriculaaluno);
		
		if (opAlunoModel.isPresent()) {
			AlunoModel updated = opAlunoModel.get();
			updated.setNomealuno(alterarAlunoModel.getNomealuno());
			updated.setTurmaaluno(alterarAlunoModel.getTurmaaluno());
			
			return this.alunoModelRepository.save(updated);
		} else {
			throw new RuntimeException ("Registro não localizado");
		}
	}
	
	public void delete (Integer matriculaaluno) {
		try {
			this.alunoModelRepository.deleteById(matriculaaluno);
		} catch (Exception e) {
			throw new RuntimeException ("Erro ao deletar" + e.getMessage());
		}
	}
	
}
