package com.ipersonal.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class AvaliacaoBasica extends EntidadeBase {
	private static final long serialVersionUID = 1L;

	private Integer idade;
	private Double altura;
	private Double peso;
	private Double imc;
	private String classificação;
	
	@ManyToOne
	private Aluno aluno;

	@OneToOne(mappedBy = "avaliacaoBasica", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private AvaliacaoCompleta avaliacaoCompleta;

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getClassificação() {
		return classificação;
	}

	public void setClassificação(String classificação) {
		this.classificação = classificação;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getImc() {
		return imc;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}

	public AvaliacaoCompleta getAvaliacaoCompleta() {
		return avaliacaoCompleta;
	}

	public void setAvaliacaoCompleta(AvaliacaoCompleta avaliacaoCompleta) {
		this.avaliacaoCompleta = avaliacaoCompleta;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "AvaliaçãoBasica [idade=" + idade + ", altura=" + altura + ", peso=" + peso + ", imc=" + imc
				+ ", classificação=" + classificação + "]";
	}

}
