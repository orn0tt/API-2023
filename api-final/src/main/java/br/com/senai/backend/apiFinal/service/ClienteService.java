package br.com.senai.backend.apiFinal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.com.senai.backend.apiFinal.config.MailConfig;
import br.com.senai.backend.apiFinal.dto.ClienteInserirDTO;
import br.com.senai.backend.apiFinal.dto.ClienteListarDTO;
import br.com.senai.backend.apiFinal.entity.Cliente;
import br.com.senai.backend.apiFinal.exception.EmailException;
import br.com.senai.backend.apiFinal.exception.ResourceNotFoundException;
import br.com.senai.backend.apiFinal.repository.ClienteRepository;
import br.com.senai.backend.apiFinal.repository.EnderecoRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	MailConfig mailConfig;

	public List<ClienteListarDTO> listarTodos() {

		List<Cliente> clientes = clienteRepository.findAll();

		List<ClienteListarDTO> ClienteListarDTO = new ArrayList<>();

		for (Cliente cliente : clientes) {

			ClienteListarDTO.add(new ClienteListarDTO(cliente));
		}

		return ClienteListarDTO;
	}

	public ClienteListarDTO buscarPorId(Long idCliente, Cliente cliente) {

		Optional<Cliente> user = clienteRepository.findById(idCliente);

		if (user.isPresent()) {

			user.get().setIdCliente(idCliente);

			return new ClienteListarDTO(clienteRepository.save(user.get()));
		}

		throw new ResourceNotFoundException("Cliente nao encontrado");
	}

	public ClienteListarDTO inserirCliente(ClienteInserirDTO dto) throws EmailException {

		Optional<Cliente> cliente = clienteRepository.findByEmail(dto.getEmail());

		if (cliente.isPresent()) {

			throw new EmailException("Email já cadastrado");
		}

		Cliente user = new Cliente();

		user.setNome(dto.getNome());
		user.setEmail(dto.getEmail());
		user.setCpf(dto.getCpf());

		var endereco = enderecoService.buscar(dto.getCep());

		if (endereco != null) {

			user.setEndereco(enderecoRepository.findById(endereco.getId()).get());
		} else {

			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}

		user = clienteRepository.save(user);

		return new ClienteListarDTO(user);
	}
}