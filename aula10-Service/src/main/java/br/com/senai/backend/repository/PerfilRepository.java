package br.com.senai.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.backend.entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}