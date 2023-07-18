package br.com.senai.backend.service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senai.backend.dto.ClienteResponseDTO;
import br.com.senai.backend.entity.Cliente;
import br.com.senai.backend.entity.Foto;
import br.com.senai.backend.exception.ResourceNotFoundException;
import br.com.senai.backend.repository.ClienteRepository;
import br.com.senai.backend.repository.FotoRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private FotoService fotoService;

	@Autowired
	private FotoRepository fotoRepository;

	public List<ClienteResponseDTO> listar() {

		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteResponseDTO> clientesDTO = new ArrayList<>();

		for (Cliente cliente : clientes) {

			clientesDTO.add(adicionarUriImagem(cliente));
		}

		return clientesDTO;
	}

	private ClienteResponseDTO adicionarUriImagem(Cliente cliente) {

		Foto foto = fotoRepository.findByCliente(cliente);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/clientes/{id}/foto")
				.buildAndExpand(foto.getIdFoto()).toUri();

		ClienteResponseDTO dto = new ClienteResponseDTO();

		dto.setNome(cliente.getNome());
		dto.setUrl(uri.toString());

		return dto;
	}

	public ClienteResponseDTO buscar(Long id) {

		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

		return adicionarUriImagem(cliente);
	}

	@Transactional
	public ClienteResponseDTO inserir(Cliente cliente, MultipartFile file) throws IOException {

		fotoService.inserirFoto(clienteRepository.save(cliente), file);

		return adicionarUriImagem(cliente);
	}
}