package br.com.senai.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Para Controle e Manutenção de Veículos", version = "1.0.1", description = "Usada para controlar os dados de manutenção dos veículos", contact = @Contact(name = "Gabriel", url = "www.google.com", email = "gabrielbclemente80@gmail.com")))
public class Aula7RelacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Aula7RelacionamentoApplication.class, args);
	}

}
