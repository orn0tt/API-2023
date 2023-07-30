package br.com.senai.backend.apiFinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.apiFinal.entity.Categoria;
import br.com.senai.backend.apiFinal.exception.ResourceNotFoundException;
import br.com.senai.backend.apiFinal.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> Listar() {

		return categoriaRepository.findAll();
	}

	// Listar Categoria por nome
	@GetMapping("nome={nome}")
	public Optional<Categoria> buscarCategoria(@PathVariable String nome) {

		Optional<Categoria> categoria = categoriaRepository.findByNome(nome);
		if (categoria.isPresent()) {

			return categoria;
		}
		throw new ResourceNotFoundException("Categoria nao Encontrado!");
	}

	// Listar Categoria por id
	@GetMapping("{id}")
	public Optional<Categoria> buscarCategoriaId(@PathVariable Long id) {

		Optional<Categoria> categoria = categoriaRepository.findById(id);

		if (categoria.isPresent()) {

			return categoria;
		}

		throw new ResourceNotFoundException("Categoria nao Encontrado!");
	}

	// Inserir Categoria
	@PostMapping
	public Categoria inserir(@RequestBody Categoria categoria) {

		Optional<Categoria> cat = categoriaRepository.findByNome(categoria.getNome());

		if (cat.isPresent()) {

			throw new ResourceNotFoundException("Categoria Ja Existe!");
		}

		return categoriaRepository.save(categoria);
	}

	// Atualizar Categoria
	@PutMapping("{idCategoria}")
	public Categoria atualizar(@RequestBody Categoria categoria, @PathVariable Long idCategoria) {

		if (categoriaRepository.findById(idCategoria).isPresent()) {

			categoria.setIdCategoria(idCategoria);
			return categoria = categoriaRepository.save(categoria);
		}

		return null;
	}
}