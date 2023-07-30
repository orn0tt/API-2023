package br.com.senai.backend.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario implements UserDetails, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@Column(length = 60, nullable = false)
	private String nome;

	@Column(length = 40, nullable = false)
	private String email;

	@Column(length = 255, nullable = false)
	private String senha;

	@OneToMany(mappedBy = "id.usuario", fetch = FetchType.EAGER)
	private Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@Override
	public String toString() {
		return "Codigo: " + idUsuario + "\n Nome: " + nome + "\n Email: " + email + "\n Perfis do usuário: "
				+ usuarioPerfis;
	}

	public Long getIdUsuario() {

		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {

		this.idUsuario = idUsuario;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getSenha() {

		return senha;
	}

	public void setSenha(String senha) {

		this.senha = senha;
	}

	public Set<UsuarioPerfil> getUsuarioPerfis() {

		return usuarioPerfis;
	}

	public Endereco getEndereco() {

		return endereco;
	}

	public void setEndereco(Endereco endereco) {

		this.endereco = endereco;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		for (UsuarioPerfil usuarioPerfil : usuarioPerfis) {

			grantedAuthorities.add(new SimpleGrantedAuthority(usuarioPerfil.getPerfil().getNome()));
		}

		return grantedAuthorities;
	}

	@Override
	public String getPassword() {

		return senha;
	}

	@Override
	public String getUsername() {

		return nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}