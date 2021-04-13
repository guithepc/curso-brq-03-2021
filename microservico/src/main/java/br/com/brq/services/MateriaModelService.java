package br.com.brq.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import br.com.brq.dtos.MateriaDTO;
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
				.orElseThrow( () -> new RuntimeException("Matéria não encontrada")  ).toDto();
	}
	
	public List<MateriaDTO> procurarPorNome(String nome){
		
		List<MateriaModel> list = this.repository.findByNomeContains(nome);
		
		return list.stream()
	            .map( x -> x.toDto() )
	            .collect(Collectors.toCollection(ArrayList::new));		
	}
	
	public MateriaDTO save(MateriaModel obj) {
		return this.repository.save(obj).toDto();
	}
	
	public MateriaDTO update(int id, MateriaModel newObj) {
				
		Optional<MateriaModel> optObj = this.repository.findById(id);
		
		if (optObj.isPresent()) {
			
			MateriaModel objFromDatabase = optObj.get();
			
			objFromDatabase.setNome(newObj.getNome());
			objFromDatabase.setProfessor(newObj.getProfessor());
			
			return this.repository.save(objFromDatabase).toDto();
		}
		else {
			throw new RuntimeException("Matéria não encontrada") ;
		}

	}
	
	public void delete(int id) {
		this.repository.deleteById(id);
	}
}