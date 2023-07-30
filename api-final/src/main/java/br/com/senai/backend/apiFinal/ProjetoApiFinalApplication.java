package br.com.senai.backend.apiFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Para Controle De E-Commerce", version = "1.0.1", description = "Usada para o controle de um E-Commerce de modo geral, podendo ter o controle de clientes, pedidos, produtos, endereços dos clientes, categorias e mais.", contact = @Contact(name = "Gabriel", url = "www.google.com", email = "orn0t@protonmail.com")))
public class ProjetoApiFinalApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjetoApiFinalApplication.class, args);
	}
}