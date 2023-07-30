package br.com.senai.backend.secutiry;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

	private JwtUtil jwtUtil;

	private UserDetailsService detailsService;

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
			UserDetailsService detailsService) {
		super(authenticationManager);
		this.jwtUtil = jwtUtil;
		this.detailsService = detailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("JWTAUTHORIZATION FILTER INTERNAL");

		String header = request.getHeader("Authorization");

		if (header != null && header.startsWith("Bearer ")) {

			UsernamePasswordAuthenticationToken auth = getAuthentication(header.substring(7));

			if (auth != null) {

				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}

		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(String token) {

		var login = jwtUtil.validateToken(token);

		System.out.println("Login " + login);

		UserDetails user = detailsService.loadUserByUsername(login);

		return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	}
}