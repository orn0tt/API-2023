package br.com.senai.backend.apiFinal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	@Autowired
	private JavaMailSender mail;

	public void enviarEmail(String para, String assunto, String texto) {

		System.out.println("teste1");
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		System.out.println("teste2");

		message.setFrom("gabriel.clemente@aluno.senai.br");
		
		System.out.println("teste3");

		message.setTo(para);
		
		System.out.println("teste4");

		message.setSubject(assunto);
		
		System.out.println("teste5");

		message.setText("Atualização na conta do usuário: \n" + texto + "\n\n\n\n" + "SENAI - API FINAL 2023");
		
		System.out.println("teste6");

		mail.send(message);
		
		System.out.println("teste7");
	}
}