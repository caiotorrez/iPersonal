package com.ipersonal.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno extends EntidadeBase {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@OneToOne
	private Perfil perfil;
	
	@OneToOne
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
