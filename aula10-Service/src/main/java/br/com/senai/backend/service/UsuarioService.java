package br.com.senai.backend.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.com.senai.backend.config.MailConfig;
import br.com.senai.backend.dto.UsuarioInserirDTO;
import br.com.senai.backend.dto.UsuarioListarDTO;
import br.com.senai.backend.entity.Usuario;
import br.com.senai.backend.entity.UsuarioPerfil;
import br.com.senai.backend.exception.EmailException;
import br.com.senai.backend.repository.EnderecoRepository;
import br.com.senai.backend.repository.UsuarioPerfilRepository;
import br.com.senai.backend.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioPerfilRepository usuarioPerfilRepository;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private BCryptPasswordEncoder criptografar;

	@Autowired
	private MailConfig mailConfig;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<UsuarioListarDTO> listarTodos() {

		List<Usuario> usuarios = usuarioRepository.findAll();

		List<UsuarioListarDTO> usuariosListarDTO = new ArrayList<>();

		for (Usuario usuario : usuarios) {

			usuariosListarDTO.add(new UsuarioListarDTO(usuario));
		}

		return usuariosListarDTO;
	}

	@Transactional
	public UsuarioListarDTO inserirUsuario(UsuarioInserirDTO dto) throws EmailException {

		Optional<Usuario> usuario = usuarioRepository.findByEmail(dto.getEmail());

		if (usuario.isPresent()) {

			throw new EmailException("Email já cadastrado.");
		}

		Usuario user = new Usuario();

		user.setNome(dto.getNome());
		user.setEmail(dto.getEmail());
		user.setSenha(criptografar.encode(dto.getSenha()));

		var endereco = enderecoRepository.findByCep(dto.getCep());

		if (endereco != null) {

			user.setEndereco(endereco);
		} else {

			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}

		// Salvar Usuario
		user = usuarioRepository.save(user);

		// Salvando os perfis do usuário cadastrado no banco
		for (UsuarioPerfil usuarioPerfil : dto.getUsuariosPerfil()) {

			usuarioPerfil.setUsuario(user);
			usuarioPerfil.setPerfil(perfilService.buscar(usuarioPerfil.getPerfil().getIdPerfil()));
			usuarioPerfil.setDataCriacao(LocalDate.now());
		}

		usuarioPerfilRepository.saveAll(dto.getUsuariosPerfil());
		mailConfig.enviarEmail(user.getEmail(), "Cadastramento de Usuário do Sistema", user.toString());
		return new UsuarioListarDTO(usuarioRepository.save(user));
	}
}
