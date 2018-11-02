package com.ipersonal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Professor extends EntidadeBase {

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Perfil perfil;
	
	@OneToMany
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
