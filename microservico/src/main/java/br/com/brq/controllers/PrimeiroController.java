package br.com.brq.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PrimeiroController {
	@GetMapping("meu-primeiro-controller")
	public String minhaPrimeiraMensagem() {
		return "Ok";
	}
	
	@GetMapping("segunda-mensagem")
	public ArrayList<String> minhaSegundaMensagem(){
		ArrayList<String> meuArray = new ArrayList<>();
		meuArray.add("String qualquer");
		return meuArray;
	}

}
