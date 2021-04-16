package br.com.brq.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.brq.dtos.AlunoDTO;
import br.com.brq.dtos.MateriaDTO;
import br.com.brq.exceptions.ObjetoNaoEncontradoExceptions;
import br.com.brq.models.AlunoMateriaModel;
import br.com.brq.models.AlunoModel;
import br.com.brq.models.MateriaModel;
import br.com.brq.repositories.AlunoMateriaRepository;
import br.com.brq.repositories.AlunoModelRepository;
import br.com.brq.repositories.EnderecoModelRepository;

@Service
public class AlunoModelService {
	
	
	@Autowired
	private AlunoModelRepository alunoModelRepository;
	
	@Autowired
	private AlunoMateriaRepository alunoMateriaRepository;
	
	@Autowired
	private EnderecoModelRepository enderecoRepository;
	
	public List<AlunoDTO> findAll(){
		List<AlunoModel> list = this.alunoModelRepository.findAll();
		
		return list.stream()
	            .map( x -> x.toDto() )
	            .collect(Collectors.toCollection(ArrayList::new));		
		
	}
	
	public AlunoDTO findOne (Integer matriculaaluno) {
		return this.alunoModelRepository.findById(matriculaaluno).orElseThrow(() -> new RuntimeException ("Error### Aluno não encontrado")).toDto();
	}
	
	
	public AlunoDTO save (AlunoDTO novoAlunoModel) {
		return this.alunoModelRepository.save(novoAlunoModel.toEntity()).toDto();
	}
	
	
	public List<AlunoDTO> procurarPorNome (String nomealuno){
		List<AlunoModel> list = this.alunoModelRepository.findByNomeContains(nomealuno);
		
		return list.stream()
				.map(x -> x.toDto())
				.collect(Collectors.toCollection(ArrayList :: new));
	}
	
	public AlunoDTO update (Integer matriculaaluno, AlunoDTO alterarAlunoModel) {
		Optional<AlunoModel> opAlunoModel =  this.alunoModelRepository.findById(matriculaaluno);
		
		if (opAlunoModel.isPresent()) {
			AlunoModel updated = opAlunoModel.get();
			updated.setNomealuno(alterarAlunoModel.getNomealuno());
			updated.setTurmaaluno(alterarAlunoModel.getTurmaaluno());
			
			return this.alunoModelRepository.save(updated).toDto();
		} else {
			throw new ObjetoNaoEncontradoExceptions ("Registro não localizado");
		}
	}
	
	@Transactional
	public void delete(int matricula) {
		
		List<AlunoMateriaModel> list = this.alunoMateriaRepository.findByAlunoId(matricula);
		
		if(list.size() > 0) {
			for (AlunoMateriaModel alunoMateriaModel : list) {
				this.alunoMateriaRepository.deleteById(alunoMateriaModel.getId());
			}
		}
		
		//this.enderecoRepository.deleteByAluno(matricula);		
		this.enderecoRepository.deleteByAlunoMatricula(matricula);
		
		//this.alunoRepository.delete(matricula);
		this.alunoModelRepository.deleteById(matricula);
	}
	
	public Page<AlunoDTO> paginacao(int pagina, int registros) {
		PageRequest pageRequest = PageRequest.of(pagina, registros);
		
		Page<AlunoModel> pageModel = this.alunoModelRepository.findAll( pageRequest );
		
		Page<AlunoDTO> pageDTO = pageModel.map(
				new Function<AlunoModel, AlunoDTO>() {
					public AlunoDTO apply(AlunoModel model) {
						return model.toDto();
					}
				}
		);
		
		return pageDTO;
		
	}
	
}
