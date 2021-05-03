package br.com.brq.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.brq.dtos.MateriaDTO;
import br.com.brq.utils.UtilTestService;
import lombok.Builder;

import org.springframework.http.HttpHeaders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@AutoConfigureMockMvc
@SpringBootTest
public class MateriaControllerTests {

	@Autowired
	private UtilTestService utilTestService;

	@Autowired
	private MockMvc mockMvc;

	private String token = null;
	
	@BeforeEach
	public void init() {
		System.out.println("init");
//		try {
//			this.token = this.utilTestService.getToken();
//		} catch (Exception e) { 
//			e.printStackTrace();
//		}
	}

	@Test
	public void testSaveMateria() throws Exception {
		
		try {
			this.token = this.utilTestService.getToken();
		} catch (Exception e) { 
			e.printStackTrace();
		}

		MateriaDTO resource = MateriaDTO.builder().nome("Matéria Test " + (int)Math.random()).professor("Professor Test" + (int)Math.random() ).build();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + this.token);
		
		ResultActions response = mockMvc
				.perform(post("/materias")
				.contentType("application/json").content(utilTestService.asJsonString(resource))
				.header("Authorization", "Bearer " + this.token)
			);

		MvcResult result = response.andReturn();
		// Verify request succeed
		Assertions.assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void testGetAllMateria() throws Exception {
		
		try {
			this.token = this.utilTestService.getToken();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + this.token);
		
		ResultActions response = mockMvc
				.perform(get("/materias")				
				.header("Authorization", "Bearer " + this.token)
			);

		MvcResult result = response.andReturn();
		// Verify request succeed
		Assertions.assertEquals(200, result.getResponse().getStatus());
	}
	
	
}