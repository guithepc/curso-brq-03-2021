package br.com.brq.utils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.brq.dtos.UsuarioLoginTestDTO;
import br.com.brq.security.AuthToken;

@Service
public class UtilTestService {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	public String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getToken() throws Exception {		

		UsuarioLoginTestDTO resource = UsuarioLoginTestDTO.builder().email("brq@brq.com").senha("123456").build();

		ResultActions response = mockMvc
				.perform(post("/autenticacao").contentType("application/json").content(asJsonString(resource))
			);

		/* Convertendo resposta para o obj Matéria */
		MvcResult result = response.andReturn();
		String contentAsString = result.getResponse().getContentAsString();

		AuthToken authToken = objectMapper.readValue(contentAsString, AuthToken.class);

		return authToken.getToken();
	}
}