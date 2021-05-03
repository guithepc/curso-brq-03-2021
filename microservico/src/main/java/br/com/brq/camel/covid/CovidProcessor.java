package br.com.brq.camel.covid;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CovidProcessor implements Processor {
		
	private CovidRepository repository;
	
	@Autowired
	public CovidProcessor(CovidRepository repository) {
		this.repository= repository;
	}
	
	@Override
	public void process(Exchange exchange) throws Exception {		
		String input = exchange.getIn().getBody(String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		DataCovidModel dataCovidModel = objectMapper.readValue(input, DataCovidModel.class);
		
		log.info(dataCovidModel.toString());
		
		repository.saveAll(dataCovidModel.getData());
	}
}