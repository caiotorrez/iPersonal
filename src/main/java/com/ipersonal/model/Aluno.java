package com.ipersonal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aluno extends EntidadeFilha {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@MapsId
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno", fetch = FetchType.EAGER)
	private List<FichaAvaliacaoFisica> fichaAvaliacaoFisica = new ArrayList<FichaAvaliacaoFisica>();
	
	public Aluno() {
	}

	public Aluno(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<FichaAvaliacaoFisica> getFichaAvaliacaoFisica() {
		return fichaAvaliacaoFisica;
	}

	public void setFichaAvaliacaoFisica(List<FichaAvaliacaoFisica> fichaAvaliacaoFisica) {
		this.fichaAvaliacaoFisica = fichaAvaliacaoFisica;
	}
}
