package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}