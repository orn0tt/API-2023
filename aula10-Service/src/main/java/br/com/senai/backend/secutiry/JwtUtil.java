package br.com.senai.backend.secutiry;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Component
public class JwtUtil {

	@Value("${auth.jwt-secret}")
	private String secret;

	public String generateToken(String nome) {

		try {

			Algorithm algorithm = Algorithm.HMAC256(secret);

			String token = JWT.create().withIssuer("auth-api").withSubject(nome).withExpiresAt(genExpirationDate())
					.sign(algorithm);

			return token;
		} catch (JWTCreationException e) {

			throw new RuntimeException("Error while generating token", e);
		}
	}

	public String validateToken(String token) {

		try {

			Algorithm algorithm = Algorithm.HMAC256(secret);

			return JWT.require(algorithm).withIssuer("auth-api").build().verify(token).getSubject();
		} catch (JWTCreationException e) {

			return "";
		}
	}

	private Instant genExpirationDate() {

		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}