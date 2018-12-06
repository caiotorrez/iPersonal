package com.ipersonal.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

public class Treino implements Serializable {
	private static final long serialVersionUID = 1L;
		
	@Embedded
	private Exercicio exercicio;
	
	@NotNull
	private Integer serie;
	
	@NotNull
	private Integer repeticoes;
	
	@NotNull
	private Integer carga;
	
	@NotNull
	private Integer angulo;
	
	@NotNull
	private String metodo;
	
	@NotNull
	private String obs;


	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public Integer getSerie() {
		return serie;
	}

	public void setSerie(Integer serie) {
		this.serie = serie;
	}

	public Integer getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(Integer repeticoes) {
		this.repeticoes = repeticoes;
	}

	public Integer getCarga() {
		return carga;
	}

	public void setCarga(Integer carga) {
		this.carga = carga;
	}

	public Integer getAngulo() {
		return angulo;
	}

	public void setAngulo(Integer angulo) {
		this.angulo = angulo;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((angulo == null) ? 0 : angulo.hashCode());
		result = prime * result + ((exercicio == null) ? 0 : exercicio.hashCode());
		result = prime * result + ((metodo == null) ? 0 : metodo.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + ((carga == null) ? 0 : carga.hashCode());
		result = prime * result + ((repeticoes == null) ? 0 : repeticoes.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treino other = (Treino) obj;
		if (angulo == null) {
			if (other.angulo != null)
				return false;
		} else if (!angulo.equals(other.angulo))
			return false;
		if (exercicio == null) {
			if (other.exercicio != null)
				return false;
		} else if (!exercicio.equals(other.exercicio))
			return false;
		if (metodo == null) {
			if (other.metodo != null)
				return false;
		} else if (!metodo.equals(other.metodo))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (carga == null) {
			if (other.carga != null)
				return false;
		} else if (!carga.equals(other.carga))
			return false;
		if (repeticoes == null) {
			if (other.repeticoes != null)
				return false;
		} else if (!repeticoes.equals(other.repeticoes))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Treino [exercicio=" + exercicio + ", serie=" + serie + ", repeticoes="
				+ repeticoes + ", carga=" + carga + ", angulo=" + angulo + ", metodo=" + metodo + ", obs=" + obs + "]";
	}
}
