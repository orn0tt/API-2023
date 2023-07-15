package br.com.senai.backend.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.senai.backend.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Funcionario findByNome(String nome);

	// @Query("select f from Funcionario f where f.salario >=:valorMinimo and
	// f.salario <=:valorMaximo")
	@Query(value = "select * from funcionario where salario between :valorMinimo and :valorMaximo", nativeQuery = true)
	Page<Funcionario> buscarSalario(Double valorMinimo, Double valorMaximo, Pageable pageable);

	// Query Method
	Page<Funcionario> findBySalarioBetween(Double valorMinimo, Double valorMaximo, Pageable pageable);

	@Query(value = "select * from funcionario where id_funcionario in (1,10,20,30)", nativeQuery = true)
	Page<Funcionario> buscarPorId(Pageable pageable);

	@Query(value = "select * from funcionario where UPPER(nome) like UPPER(CONCAT('%',:paramNome,'%'))", nativeQuery = true)
	Page<Funcionario> buscarPorParteDoNome(String paramNome, Pageable pageable);

	Page<Funcionario> findByNomeContainingIgnoreCase(String paramNome, Pageable pageable);

	Page<Funcionario> findByNomeStartingWithIgnoreCase(String paramNome, Pageable pageable);

	Page<Funcionario> findByDataNascimentoGreaterThan(LocalDate paramData, Pageable pageable);
}