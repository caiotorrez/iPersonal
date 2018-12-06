package com.ipersonal.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class AvaliacaoCompleta extends EntidadeFilha {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@MapsId
	private AvaliacaoBasica avaliacaoBasica;

	@Embedded
	private Antropometria antropometria;

	@Embedded
	private ComposicaoCorporal composicaoCorporal;

	public Antropometria getAntropometria() {
		return antropometria;
	}

	public void setAntropometria(Antropometria antropometria) {
		this.antropometria = antropometria;
	}

	public ComposicaoCorporal getComposicaoCorporal() {
		return composicaoCorporal;
	}

	public void setComposicaoCorporal(ComposicaoCorporal composicaoCorporal) {
		this.composicaoCorporal = composicaoCorporal;
	}

	public AvaliacaoBasica getAvaliacaoBasica() {
		return avaliacaoBasica;
	}

	public void setAvaliacaoBasica(AvaliacaoBasica avaliacaoBasica) {
		this.avaliacaoBasica = avaliacaoBasica;
	}

}
