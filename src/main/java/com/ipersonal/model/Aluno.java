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
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
	private List<FichaAvaliacaoFisica> fichaAvaliacaoFisica = new ArrayList<FichaAvaliacaoFisica>();
	
//	private List<FichaTreino> fichaTreino = new ArrayList<FichaTreino>();

}
