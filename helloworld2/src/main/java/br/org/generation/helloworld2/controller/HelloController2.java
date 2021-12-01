package br.org.generation.helloworld2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello2")
public class HelloController2 {

	@GetMapping
	public String helloShow() {
		return "Meus objetivos de apredizagem da semana: Aprender Spring e avançar com o Projeto Integrador";
	}
}
