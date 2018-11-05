package com.ipersonal.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class FichaAvaliacaoFisica extends EntidadeBase {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@NotNull
	@Min(value = 0)
	private Integer idade;

	@NotNull
	@Min(value = 0)
	private Integer peso;
	
	@NotNull
	@Min(value = 0)
	private Double estatura;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "fichaAvaliacaoFisica")
	private Anamnese anamnese;

	@OneToOne(cascade = CascadeType.ALL)
	private Antropometria antropometria;

	@OneToOne(cascade = CascadeType.ALL)
	private ComposicaoCorporal composicaoCorporal;

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	public Anamnese getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(Anamnese anamnese) {
		this.anamnese = anamnese;
	}

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
	
}
