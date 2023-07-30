package br.com.senai.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.senai.backend.entity.Usuario;
import br.com.senai.backend.exception.ResourceNotFoundException;
import br.com.senai.backend.repository.UsuarioRepository;

@Service
public class UsuarioDetalheImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// Vai verificar a autenticação pelo login do usuário. Pode ser um nome, email ou cpf
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("procurano o nome do usuário");

		Usuario usuario = usuarioRepository.findByNome(username)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));

		return usuario;
	}
}