package br.com.senai.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Trabalho em Grupo 2 - API", version = "1.0.1", description = "Usada para controle de vendas.", contact = @Contact(name = "Gabriel, Artur, André", url = "www.google.com", email = "exemplo@gmail.com")))
public class TrabalhoEmGrupo2ApiRest1Application {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoEmGrupo2ApiRest1Application.class, args);
	}
}