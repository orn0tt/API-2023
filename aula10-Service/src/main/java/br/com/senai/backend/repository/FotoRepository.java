package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Cliente;
import br.com.senai.backend.entity.Foto;

public interface FotoRepository extends JpaRepository<Foto, Long> {

	Foto findByCliente(Cliente cliente);
}