package br.com.brq.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.function.Function;
import org.springframework.stereotype.Service;



import br.com.brq.dtos.MateriaDTO;
import br.com.brq.exceptions.ObjetoNaoEncontradoExceptions;
import br.com.brq.models.MateriaModel;
import br.com.brq.repositories.MateriaModelRepository;

@Service
public class MateriaModelService {
	
	@Autowired
	private MateriaModelRepository repository;
	
	public List<MateriaDTO> findAll(){
		
		List<MateriaModel> list = this.repository.findAll();
		
		return list.stream()
	            .map( x -> x.toDto() )
	            .collect(Collectors.toCollection(ArrayList::new));		
	}
	
	public MateriaDTO findOne(int id) {
		return this.repository.findById(id)
				.orElseThrow( () -> new ObjetoNaoEncontradoExceptions("Matéria não encontrada")  ).toDto();
	}
	
	public List<MateriaDTO> procurarPorNome(String nome){
		
		List<MateriaModel> list = this.repository.findByNomeContains(nome);
		
		return list.stream()
	            .map( x -> x.toDto() )
	            .collect(Collectors.toCollection(ArrayList::new));		
	}
	
	public MateriaDTO save(MateriaDTO obj) {
		return this.repository.save(obj.toEntity()).toDto();
	}
	
	public MateriaDTO update(int id, MateriaDTO newObj) {
				
		Optional<MateriaModel> optObj = this.repository.findById(id);
		
		if (optObj.isPresent()) {
			
			MateriaModel objFromDatabase = optObj.get();
			
			objFromDatabase.setNome(newObj.getNome());
			objFromDatabase.setProfessor(newObj.getProfessor());
			
			return this.repository.save(objFromDatabase).toDto();
		}
		else {
			throw new ObjetoNaoEncontradoExceptions("Matéria não encontrada") ;
		}

	}
	
	public void delete(int id) {
		this.repository.deleteById(id);
	}
	
	public void deleteMany(int[] ids) {
		for (int i : ids) {
			this.repository.deleteById(i);
		}
		
	}	
	
	public Page<MateriaDTO> paginacao(int pagina, int registros) {
		PageRequest pageRequest = PageRequest.of(pagina, registros);
		
		Page<MateriaModel> pageModel = this.repository.findAll( pageRequest );
		
		Page<MateriaDTO> pageDTO = pageModel.map(
				new Function<MateriaModel, MateriaDTO>() {
					public MateriaDTO apply(MateriaModel model) {
						return model.toDto();
					}
				}
		);
		
		return pageDTO;
		
	}

}



