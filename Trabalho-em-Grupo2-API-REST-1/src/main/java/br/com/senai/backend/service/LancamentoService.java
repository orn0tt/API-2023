package br.com.senai.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.com.senai.backend.dto.LancamentoVendasMostrarDTO;
import br.com.senai.backend.entity.LancamentoVendas;
import br.com.senai.backend.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	public LancamentoVendasMostrarDTO listarPorId(Long id) {

		Optional<LancamentoVendas> lancamentoVendas = lancamentoRepository.findById(id);

		if (lancamentoVendas.isPresent()) {

			return new LancamentoVendasMostrarDTO(lancamentoVendas.get());

		} else {

			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
	}

	public LancamentoVendasMostrarDTO inserirLancamento(LancamentoVendas lancamentoVendas) {

		lancamentoVendas = lancamentoRepository.save(lancamentoVendas);

		return new LancamentoVendasMostrarDTO(lancamentoVendas);
	}

	public Page<LancamentoVendasMostrarDTO> listarPorPagina(Pageable pageable) {

		Page<LancamentoVendas> lancamentoVendas = lancamentoRepository.findAll(pageable);

		return lancamentoVendas.map(l -> new LancamentoVendasMostrarDTO(l));
	}
}