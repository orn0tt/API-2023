package br.com.senai.backend.secutiry;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.senai.backend.entity.Usuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	private JwtUtil jwtUtil;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {

			System.out.println("attempt");

			Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

			System.out.println("USUÁRIO" + usuario.getNome());

			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(usuario.getNome(),
					usuario.getSenha(), new ArrayList<>());

			System.out.println("APOS UsernamePassworAuthenticationToken");

			Authentication auth = authenticationManager.authenticate(authToken);

			System.out.println("APOS AUTHENTICATE");

			return auth;
		} catch (Exception e) {

			throw new RuntimeException("Falha ao autenticar usuário", e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String nome = ((Usuario) authResult.getPrincipal()).getUsername();

		System.out.println("SUCESSO");

		String token = jwtUtil.generateToken(nome);

		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("acess-control-expose-headers", "Authorization");
	}
}