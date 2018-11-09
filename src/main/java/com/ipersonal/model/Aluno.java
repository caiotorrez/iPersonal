package com.ipersonal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aluno extends EntidadeBase {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Usuario usuario;
	
	@OneToOne
	@MapsId
	private Perfil perfil;
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
	private List<FichaAvaliacaoFisica> fichaAvaliacaoFisica = new ArrayList<FichaAvaliacaoFisica>();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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
	
//	private List<FichaTreino> fichaTreino = new ArrayList<FichaTreino>();

}
