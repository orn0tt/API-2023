package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

}