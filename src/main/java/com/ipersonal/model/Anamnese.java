package com.ipersonal.model;

import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Anamnese extends EntidadeBase {
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@MapsId
	private FichaAvaliacaoFisica fichaAvaliacaoFisica;
	
	

}
