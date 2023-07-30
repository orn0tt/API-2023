package br.com.senai.backend.apiFinal.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.senai.backend.apiFinal.dto.EnderecoListarDTO;
import br.com.senai.backend.apiFinal.entity.Endereco;
import br.com.senai.backend.apiFinal.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public EnderecoListarDTO buscar(String cep) throws HttpClientErrorException {

		var endereco = Optional.ofNullable(enderecoRepository.findByCep(cep));

		if (endereco.isPresent()) {

			return new EnderecoListarDTO(endereco.get());
		} else {

			RestTemplate rs = new RestTemplate();

			String uri = "https://viacep.com.br/ws/" + cep + "/json/";

			Optional<Endereco> enderecoViaCep = Optional.ofNullable(rs.getForObject(uri, Endereco.class));

			if (enderecoViaCep.get().getCep() != null) {

				String cepSemTraco = enderecoViaCep.get().getCep().replaceAll("-", "");

				enderecoViaCep.get().setCep(cepSemTraco);

				return inserir(enderecoViaCep.get());
			} else {

				throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
			}
		}
	}

	private EnderecoListarDTO inserir(Endereco endereco) {

		endereco = enderecoRepository.save(endereco);

		return new EnderecoListarDTO(endereco);
	}
}