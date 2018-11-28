package com.ipersonal.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Professor extends EntidadeBase {

	private static final long serialVersionUID = 1L;
	
	
	@OneToOne
	@MapsId
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@NotNull(message = "O CREF não pode ser em branco")
	private String cref;
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
	private Set<Aluno> alunos = new HashSet<>();
	
	
	public Professor() {
	}
	
	public Professor(String cref) {
		this.cref = cref;
	}
	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}
}
