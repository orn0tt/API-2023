package br.com.senai.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.backend.entity.Perfil;
import br.com.senai.backend.repository.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	public Perfil buscar(Long id) {

		Optional<Perfil> perfil = perfilRepository.findById(id);

		if (perfil.isPresent()) {

			return perfil.get();
		}
		return null;
	}
}