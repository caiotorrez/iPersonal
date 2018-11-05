package com.ipersonal.model;

import javax.persistence.Entity;

@Entity
public class ComposicaoCorporal extends EntidadeBase {
	private static final long serialVersionUID = 1L;
	
	private Double percentualGordura;
	
	private Double massaMagra;
	
	private Double massaGorda;
	
	private Double massaMuscular;
	
	private Double massaOssea;
	
	private Double massaResidual;
	
	private Double indiceCinturaQuadril;
	
	private String classificacaoICQ;
	
	private Double indiceMassaCorporea;
	
	private String classificacaoIMC;
	
	private Double pesoIdeal;

	public Double getPercentualGordura() {
		return percentualGordura;
	}

	public void setPercentualGordura(Double percentualGordura) {
		this.percentualGordura = percentualGordura;
	}

	public Double getMassaMagra() {
		return massaMagra;
	}

	public void setMassaMagra(Double massaMagra) {
		this.massaMagra = massaMagra;
	}

	public Double getMassaGorda() {
		return massaGorda;
	}

	public void setMassaGorda(Double massaGorda) {
		this.massaGorda = massaGorda;
	}

	public Double getMassaMuscular() {
		return massaMuscular;
	}

	public void setMassaMuscular(Double massaMuscular) {
		this.massaMuscular = massaMuscular;
	}

	public Double getMassaOssea() {
		return massaOssea;
	}

	public void setMassaOssea(Double massaOssea) {
		this.massaOssea = massaOssea;
	}

	public Double getMassaResidual() {
		return massaResidual;
	}

	public void setMassaResidual(Double massaResidual) {
		this.massaResidual = massaResidual;
	}

	public Double getIndiceCinturaQuadril() {
		return indiceCinturaQuadril;
	}

	public void setIndiceCinturaQuadril(Double indiceCinturaQuadril) {
		this.indiceCinturaQuadril = indiceCinturaQuadril;
	}

	public String getClassificacaoICQ() {
		return classificacaoICQ;
	}

	public void setClassificacaoICQ(String classificacaoICQ) {
		this.classificacaoICQ = classificacaoICQ;
	}

	public Double getIndiceMassaCorporea() {
		return indiceMassaCorporea;
	}

	public void setIndiceMassaCorporea(Double indiceMassaCorporea) {
		this.indiceMassaCorporea = indiceMassaCorporea;
	}

	public String getClassificacaoIMC() {
		return classificacaoIMC;
	}

	public void setClassificacaoIMC(String classificacaoIMC) {
		this.classificacaoIMC = classificacaoIMC;
	}

	public Double getPesoIdeal() {
		return pesoIdeal;
	}

	public void setPesoIdeal(Double pesoIdeal) {
		this.pesoIdeal = pesoIdeal;
	}

	@Override
	public String toString() {
		return "ComposicaoCorporal [percentualGordura=" + percentualGordura + ", massaMagra=" + massaMagra
				+ ", massaGorda=" + massaGorda + ", massaMuscular=" + massaMuscular + ", massaOssea=" + massaOssea
				+ ", massaResidual=" + massaResidual + ", indiceCinturaQuadril=" + indiceCinturaQuadril
				+ ", classificacaoICQ=" + classificacaoICQ + ", indiceMassaCorporea=" + indiceMassaCorporea
				+ ", classificacaoIMC=" + classificacaoIMC + ", pesoIdeal=" + pesoIdeal + "]";
	}
	
}
