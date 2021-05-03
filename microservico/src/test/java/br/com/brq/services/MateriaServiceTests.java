package br.com.brq.services;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.brq.dtos.MateriaDTO;
import br.com.brq.models.MateriaModel;
import br.com.brq.repositories.MateriaRepository;

import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class MateriaServiceTests {

	@InjectMocks
	private MateriaService service;
	
	@Mock
	private MateriaRepository repository;
	
	@Test
    public void whenFindAll_thenReturnList() {
		
        // given
		MateriaModel resource = MateriaModel
				.builder()
				.nome("Matéria Test " + (int)Math.random())
				.professor("Professor Test" + (int)Math.random() )
				.build();
		
        List<MateriaModel> expectedResources = Arrays.asList(resource);
        
        List<MateriaDTO> expectedResourcesDTO = expectedResources.stream()
	            .map( x -> x.toDto() )
	            .collect(Collectors.toCollection(ArrayList::new));

        doReturn(expectedResources).when(repository).findAll();

        // when
        List<MateriaDTO> actualRessources = service.findAll();

        // then
        assertThat(actualRessources).isEqualTo(expectedResourcesDTO);
    }
	
}
