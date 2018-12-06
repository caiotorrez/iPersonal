package com.ipersonal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class FichaDeTreino extends EntidadeBase {
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Aluno aluno;

	@NotNull
	@Length(max = 20)
	private String titulo;
	
	@NotNull
	private String objetivo;

	private String obs;

	@ElementCollection
	private List<Treino> treinos = new ArrayList<>();

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}
	
	
	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String toString() {
		return "FichaDeTreino [titulo=" + titulo + "]";
	}
}
