package br.com.senai.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Para Controle De Clínica", version = "1.0.1", description = "Usada para o controle de pacientes, médicos e agendamento de consultas.", contact = @Contact(name = "Gabriel", url = "www.google.com", email = "orn0t@protonmail.com")))
public class TrabalhoEmGrupoApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoEmGrupoApiRestApplication.class, args);
	}

}
