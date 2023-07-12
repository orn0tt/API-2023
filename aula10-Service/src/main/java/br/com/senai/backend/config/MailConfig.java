package br.com.senai.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	@Autowired
	private JavaMailSender mail;

	public void enviarEmail(String para, String assunto, String texto) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("gabriel.clemente@aluno.senai.br");
		message.setTo(para);
		message.setSubject(assunto);
		message.setText("Dados de incrição:\n" + texto + "\n\n\n\n" + "SENAI - PROGRAMAÇÃO 2023");
		mail.send(message);
	}
}