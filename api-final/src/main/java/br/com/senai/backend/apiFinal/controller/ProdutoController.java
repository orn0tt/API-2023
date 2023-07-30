package br.com.senai.backend.apiFinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.apiFinal.entity.Categoria;
import br.com.senai.backend.apiFinal.entity.Produto;
import br.com.senai.backend.apiFinal.exception.ResourceNotFoundException;
import br.com.senai.backend.apiFinal.repository.CategoriaRepository;
import br.com.senai.backend.apiFinal.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Produto> Listar() {

		return produtoRepository.findAll();
	}

	// Listar Produto por Codigo do Produto
	@GetMapping("{codigoProduto}")
	public Optional<Produto> buscarProduto(@PathVariable Long codigoProduto) {

		return produtoRepository.findById(codigoProduto);
	}

	// Listar Produto por nome
	@GetMapping("nome={nome}")
	public Optional<Produto> buscarProduto(@PathVariable String nome) {

		Optional<Produto> produto = produtoRepository.findByNome(nome);

		if (produto.isPresent()) {

			return produto;
		}

		throw new ResourceNotFoundException("Produto nao Encontrado!");
	}

	// Inserir Produto
	@PostMapping
	public Produto inserir(@RequestBody Produto produto) {

		Optional<Categoria> categoria = categoriaRepository.findById(produto.getCategoria().getIdCategoria());

		if (categoria.isPresent()) {

			return produtoRepository.save(produto);
		}

		throw new ResourceNotFoundException("Categoria Nao encontrada!");
	}

	// Atualizar Produto
	@PutMapping("{codigoProduto}")
	public Produto atualizar(@RequestBody Produto produto, @PathVariable Long codigoProduto) {

		if (produtoRepository.findById(codigoProduto).isPresent()) {

			produto.setCodigoProduto(codigoProduto);

			return produto = produtoRepository.save(produto);
		}

		return null;
	}

	// Deletar Produto pelo Codigo
	@DeleteMapping("{codigoProduto}")
	public void apagar(@PathVariable Long codigoProduto) {

		if (produtoRepository.existsById(codigoProduto)) {

			produtoRepository.deleteById(codigoProduto);
		}
	}
}