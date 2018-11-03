package com.ipersonal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Professor extends EntidadeBase {

	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Perfil perfil;

	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Usuario usuario;
	
	@ElementCollection
	@Column(name = "alunos_do_professor")
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	@NotNull(message = "O CREF não pode ser em branco")
	private String cref;
	
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
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
