package br.com.senai.backend.apiFinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.backend.apiFinal.dto.PedidoResponseDTO;
import br.com.senai.backend.apiFinal.entity.Cliente;
import br.com.senai.backend.apiFinal.entity.ItemPedido;
import br.com.senai.backend.apiFinal.entity.Pedido;
import br.com.senai.backend.apiFinal.entity.Produto;
import br.com.senai.backend.apiFinal.exception.ResourceNotFoundException;
import br.com.senai.backend.apiFinal.repository.ClienteRepository;
import br.com.senai.backend.apiFinal.repository.ItemPedidoRepository;
import br.com.senai.backend.apiFinal.repository.PedidoRepository;
import br.com.senai.backend.apiFinal.repository.ProdutoRepository;
import br.com.senai.backend.apiFinal.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public List<Pedido> Listar() {

		return pedidoRepository.findAll();
	}

	@GetMapping("{idPedido}")
	public ResponseEntity<PedidoResponseDTO> listarPorId(@PathVariable Long idPedido) {

		PedidoResponseDTO pedido = pedidoService.buscarPedido(idPedido);

		if (pedido != null) {

			return ResponseEntity.ok(pedido);

		} else {

			return ResponseEntity.notFound().build();
		}
	}

	// Inserir Pedido
	@PostMapping
	public PedidoResponseDTO inserir(@RequestBody Pedido pedido) {

		Optional<Cliente> cliente = clienteRepository.findById(pedido.getCliente().getIdCliente());

		pedido.setCliente(cliente.get());

		if (cliente.isPresent()) {

			pedido = pedidoRepository.save(pedido);

			for (ItemPedido itemPedido : pedido.getItens()) {

				itemPedido.setPedido(pedido);

				Optional<Produto> produto = produtoRepository.findById(itemPedido.getProduto().getIdProduto());

				itemPedido.setProduto(produto.get());
			}

			itemPedidoRepository.saveAll(pedido.getItens());

			return new PedidoResponseDTO(pedido);
		}

		throw new ResourceNotFoundException("Cliente nao Encontrado!");
	}

	// Atualizar Pedido
	@PutMapping("{idPedido}")
	public Pedido atualizar(@RequestBody Pedido pedido, @PathVariable Long idPedido) {

		if (pedidoRepository.findById(idPedido).isPresent()) {

			pedido.setIdPedido(idPedido);

			return pedido = pedidoRepository.save(pedido);
		}

		return null;
	}

	// Deletar Pedido pelo Codigo
	@DeleteMapping("{idPedido}")
	public void apagar(@PathVariable Long codigoPedido) {

		if (pedidoRepository.existsById(codigoPedido)) {

			pedidoRepository.deleteById(codigoPedido);
		}
	}
}