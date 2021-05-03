package br.com.brq.camel.covid;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CovidCamel extends RouteBuilder {
	
	@Autowired
	private CovidRepository repository;
	
	@Override
	public void configure() throws Exception {
				
		//from("timer:covid?period={{timer.period}}")
			//.to("https://covid19-brazil-api.now.sh/api/report/v1")
			//.process(new CovidProcessor(repository) )
			//.log("${body}");		
	}

}
