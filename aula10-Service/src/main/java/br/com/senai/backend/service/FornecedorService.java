package br.com.senai.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.senai.backend.dto.FornecedorListarDTO;
import br.com.senai.backend.entity.Fornecedor;
import br.com.senai.backend.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public FornecedorListarDTO buscar(String cnpj) throws HttpClientErrorException {

		var fornecedor = Optional.ofNullable(fornecedorRepository.findByCnpj(cnpj));

		if (fornecedor.isPresent()) {

			return new FornecedorListarDTO(fornecedor.get());

		} else {

			RestTemplate rs = new RestTemplate();
			String uri = "https://receitaws.com.br/v1/cnpj/" + cnpj;
			Optional<Fornecedor> fornecedorConsulta = Optional.ofNullable(rs.getForObject(uri, Fornecedor.class));

			if (fornecedorConsulta.get().getCnpj() != null) {

				String cnpjFiltro = fornecedorConsulta.get().getCnpj().replaceAll("[-/.]", "");

				fornecedorConsulta.get().setCnpj(cnpjFiltro);

				return inserir(fornecedorConsulta.get());

			} else {

				throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
			}
		}
	}

	private FornecedorListarDTO inserir(Fornecedor fornecedor) {

		fornecedor = fornecedorRepository.save(fornecedor);

		return new FornecedorListarDTO(fornecedor);
	}
}