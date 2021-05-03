package br.com.brq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.brq.models.MateriaModel;

@SpringBootApplication
public class MicroservicoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MicroservicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		MateriaModel m = new MateriaModel();
		m.setNome("Materia Teste");
		
		
		//Builder
		MateriaModel builder1 = MateriaModel
				.builder()
				.nome("Materia Builder")
				.professor("Arnaldo")
				.build();
		
		System.out.println(builder1);
		
				
				 

		
	}
}
