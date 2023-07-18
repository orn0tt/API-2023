package br.com.senai.backend.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.senai.backend.entity.Cliente;
import br.com.senai.backend.entity.Foto;
import br.com.senai.backend.exception.ResourceNotFoundException;
import br.com.senai.backend.repository.FotoRepository;

@Service
public class FotoService {

	@Autowired
	private FotoRepository fotoRepository;

	public Foto inserirFoto(Cliente cliente, MultipartFile file) throws IOException {

		Foto foto = new Foto(null, file.getBytes(), file.getName(), file.getContentType(), cliente);

		return fotoRepository.save(foto);
	}

	public Foto buscarFoto(Long id) {

		/*
		 * Optional<Foto> foto = fotoRepository.findById(id);
		 * 
		 * if (foto.isPresent()) {
		 * 
		 * return foto.get();
		 * 
		 * } else {
		 * 
		 * return null; }
		 */

		return fotoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
	}
}