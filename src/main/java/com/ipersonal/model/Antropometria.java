package com.ipersonal.model;

import javax.persistence.Embeddable;

@Embeddable
public class Antropometria extends EntidadeFilha {
	private static final long serialVersionUID = 1L;


	// Dobras Cutaneas
	private Double dobraTriceps;

	private Double dobraSubescapular;

	private Double dobraSupraIliaca;

	private Double dobraAbdomen;

	// Circuferencias

	private Double bracoDireito;

	private Double bracoEsquerdo;

	private Double antiBracoDireito;

	private Double antiBracoEsquerdo;

	private Double abdomen;

	private Double cintura;

	private Double coxaDireita;

	private Double coxaEsquerda;

	private Double pernaDireita;

	private Double pernaEsquerda;

	public Double getDobraTriceps() {
		return dobraTriceps;
	}

	public void setDobraTriceps(Double dobraTriceps) {
		this.dobraTriceps = dobraTriceps;
	}

	public Double getDobraSubescapular() {
		return dobraSubescapular;
	}

	public void setDobraSubescapular(Double dobraSubescapular) {
		this.dobraSubescapular = dobraSubescapular;
	}

	public Double getDobraSupraIliaca() {
		return dobraSupraIliaca;
	}

	public void setDobraSupraIliaca(Double dobraSupraIliaca) {
		this.dobraSupraIliaca = dobraSupraIliaca;
	}

	public Double getDobraAbdomen() {
		return dobraAbdomen;
	}

	public void setDobraAbdomen(Double dobraAbdomen) {
		this.dobraAbdomen = dobraAbdomen;
	}

	public Double getBracoDireito() {
		return bracoDireito;
	}

	public void setBracoDireito(Double bracoDireito) {
		this.bracoDireito = bracoDireito;
	}

	public Double getBracoEsquerdo() {
		return bracoEsquerdo;
	}

	public void setBracoEsquerdo(Double bracoEsquerdo) {
		this.bracoEsquerdo = bracoEsquerdo;
	}

	public Double getAntiBracoDireito() {
		return antiBracoDireito;
	}

	public void setAntiBracoDireito(Double antiBracoDireito) {
		this.antiBracoDireito = antiBracoDireito;
	}

	public Double getAntiBracoEsquerdo() {
		return antiBracoEsquerdo;
	}

	public void setAntiBracoEsquerdo(Double antiBracoEsquerdo) {
		this.antiBracoEsquerdo = antiBracoEsquerdo;
	}

	public Double getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(Double abdomen) {
		this.abdomen = abdomen;
	}

	public Double getCintura() {
		return cintura;
	}

	public void setCintura(Double cintura) {
		this.cintura = cintura;
	}

	public Double getCoxaDireita() {
		return coxaDireita;
	}

	public void setCoxaDireita(Double coxaDireita) {
		this.coxaDireita = coxaDireita;
	}

	public Double getCoxaEsquerda() {
		return coxaEsquerda;
	}

	public void setCoxaEsquerda(Double coxaEsquerda) {
		this.coxaEsquerda = coxaEsquerda;
	}

	public Double getPernaDireita() {
		return pernaDireita;
	}

	public void setPernaDireita(Double pernaDireita) {
		this.pernaDireita = pernaDireita;
	}

	public Double getPernaEsquerda() {
		return pernaEsquerda;
	}

	public void setPernaEsquerda(Double pernaEsquerda) {
		this.pernaEsquerda = pernaEsquerda;
	}

	@Override
	public String toString() {
		return "Antropometria [dobraTriceps=" + dobraTriceps + ", dobraSubescapular=" + dobraSubescapular
				+ ", dobraSupraIliaca=" + dobraSupraIliaca + ", dobraAbdomen=" + dobraAbdomen + ", bracoDireito="
				+ bracoDireito + ", bracoEsquerdo=" + bracoEsquerdo + ", antiBracoDireito=" + antiBracoDireito
				+ ", antiBracoEsquerdo=" + antiBracoEsquerdo + ", abdomen=" + abdomen + ", cintura=" + cintura
				+ ", coxaDireita=" + coxaDireita + ", coxaEsquerda=" + coxaEsquerda + ", pernaDireita=" + pernaDireita
				+ ", pernaEsquerda=" + pernaEsquerda + "]";
	}

}
