package com.ipersonal.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Professor extends EntidadeBase {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Perfil perfil;
	
	@NotNull(message = "O CREF não pode ser em branco")
	private String cref;

	@JsonIgnore
	@OneToOne
	@MapsId
	private Usuario usuario;
	
	@OneToMany(mappedBy = "professor")
	private Set<Aluno> alunos = new HashSet<>();
	
	
	public Professor() {
	}
	
	public Professor(Perfil perfil, String cref) {
		this.perfil = perfil;
		this.cref = cref;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}
	
}
