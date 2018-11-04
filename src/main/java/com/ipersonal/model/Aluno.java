package com.ipersonal.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aluno extends EntidadeBase {

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Usuario usuario;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Perfil perfil;
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
//	@ElementCollection
//	private List<FichaAvaliacaoFisica> fichaAvaliacaoFisica = new ArrayList<FichaAvaliacaoFisica>();
//	
//	@OneToOne
//	private Anamnese anamnese;
//	
//	@ElementCollection
//	private List<FichaTreino> fichaTreino = new ArrayList<FichaTreino>();

}
