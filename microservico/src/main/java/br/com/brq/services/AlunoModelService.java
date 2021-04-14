package br.com.brq.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.dtos.AlunoDTO;
import br.com.brq.models.AlunoModel;
import br.com.brq.repositories.AlunoModelRepository;

@Service
public class AlunoModelService {
	
	
	@Autowired
	private AlunoModelRepository alunoModelRepository;
	
	public List<AlunoDTO> findAll(){
		List<AlunoModel> list = this.alunoModelRepository.findAll();
		
		return list.stream()
	            .map( x -> x.toDto() )
	            .collect(Collectors.toCollection(ArrayList::new));		
		
	}
	
	public AlunoDTO findOne (Integer matriculaaluno) {
		return this.alunoModelRepository.findById(matriculaaluno).orElseThrow(() -> new RuntimeException ("Error### Aluno não encontrado")).toDto();
	}
	
	
	public AlunoDTO save (AlunoModel novoAlunoModel) {
		return this.alunoModelRepository.save(novoAlunoModel).toDto();
	}
	
	
	public List<AlunoDTO> procurarPorNome (String nomealuno){
		List<AlunoModel> list = this.alunoModelRepository.findByNomeContains(nomealuno);
		
		return list.stream()
				.map(x -> x.toDto())
				.collect(Collectors.toCollection(ArrayList :: new));
	}
	
	public AlunoDTO update (Integer matriculaaluno, AlunoModel alterarAlunoModel) {
		Optional<AlunoModel> opAlunoModel =  this.alunoModelRepository.findById(matriculaaluno);
		
		if (opAlunoModel.isPresent()) {
			AlunoModel updated = opAlunoModel.get();
			updated.setNomealuno(alterarAlunoModel.getNomealuno());
			updated.setTurmaaluno(alterarAlunoModel.getTurmaaluno());
			
			return this.alunoModelRepository.save(updated).toDto();
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
