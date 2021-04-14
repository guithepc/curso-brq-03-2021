package br.com.brq.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brq.dtos.EscolaDTO;
import br.com.brq.dtos.MateriaDTO;
import br.com.brq.models.EscolaModel;
import br.com.brq.models.MateriaModel;
import br.com.brq.repositories.EscolaModelRepository;

@Service
public class EscolaModelServices {
	
	
	@Autowired
	private EscolaModelRepository escolaModelRepository;

	public List<EscolaDTO> findAll(){
		
		List<EscolaModel> list = this.escolaModelRepository.findAll();
		
		return list.stream()
				.map(x -> x.toDto() )
				.collect(Collectors.toCollection(ArrayList::new));
		
	}
	
	public EscolaDTO findOne(Integer id){
		return this.escolaModelRepository.findById(id).orElseThrow(() -> new RuntimeException ("Error### Escola não encontrada")).toDto();
	}
	
	
	public List<EscolaDTO> procurarPorNome(String nome){
		
		List<EscolaModel> list = this.escolaModelRepository.findByNomeContains(nome);
		
		return list.stream()
	            .map( x -> x.toDto() )
	            .collect(Collectors.toCollection(ArrayList::new));	
	}
	
	public EscolaDTO save (EscolaModel novoEscolaModel) {
		return this.escolaModelRepository.save(novoEscolaModel).toDto();
	}
	
	public EscolaDTO update (Integer id, EscolaModel alterarEscolaModel) {
		Optional<EscolaModel> opEscolaModel = this.escolaModelRepository.findById(id);
		
		if (opEscolaModel.isPresent()) {
			EscolaModel updated = opEscolaModel.get();
			updated.setNome(alterarEscolaModel.getNome());
			updated.setTipo_escola(alterarEscolaModel.getTipo_escola());
			updated.setNumero_salas(alterarEscolaModel.getNumero_salas());
			
			return this.escolaModelRepository.save(updated).toDto();
		} else {
			throw new RuntimeException ("Registro não localizado");

		}
	}
	
	
	public void delete (Integer id) {
		try {
			this.escolaModelRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException ("Erro ao deletar" + e.getMessage());
		}
	}
}




