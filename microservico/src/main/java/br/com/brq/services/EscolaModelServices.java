package br.com.brq.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.brq.dtos.EscolaDTO;
import br.com.brq.exceptions.ObjetoNaoEncontradoExceptions;
import br.com.brq.models.EscolaModel;
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
	
	public EscolaDTO save (EscolaDTO novoEscolaModel) {
		return this.escolaModelRepository.save(novoEscolaModel.toEntity()).toDto();
	}
	
	public EscolaDTO update (Integer id, EscolaDTO alterarEscolaModel) {
		Optional<EscolaModel> opEscolaModel = this.escolaModelRepository.findById(id);
		
		if (opEscolaModel.isPresent()) {
			
			EscolaModel updated = opEscolaModel.get();
			
			updated.setNome(alterarEscolaModel.getNome());
			updated.setTipo_escola(alterarEscolaModel.getTipo_escola());
			updated.setNumero_salas(alterarEscolaModel.getNumero_salas());
			
			return this.escolaModelRepository.save(updated).toDto();
		} else {
			throw new ObjetoNaoEncontradoExceptions ("Registro não localizado");

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
	
	public Page<EscolaDTO> paginacao(int pagina, int registros){
		PageRequest pageRequest = PageRequest.of(pagina, registros);
		
		Page<EscolaModel> pageModel = this.escolaModelRepository.findAll(pageRequest);
		
		Page<EscolaDTO> pageDTO = pageModel.map(
				new Function<EscolaModel, EscolaDTO>(){
					public EscolaDTO apply(EscolaModel model) {
						return model.toDto();
					}
				}
				
			);
		return pageDTO;
	}
}




