package com.ipersonal.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Aluno extends EntidadeFilha {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@MapsId
	private Usuario usuario;

	@OneToOne(cascade = CascadeType.ALL)
	private Anamnese anamnese;

	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;

	@OneToMany(cascade = CascadeType.ALL)
	private List<AvaliacaoBasica> avaliacaoFisica = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id_ficha_de_treino_id")
	private Set<FichaDeTreino> fichaDeTreino = new HashSet<>();

	public Aluno() {
	}

	public Aluno(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<AvaliacaoBasica> getAvaliacaoFisica() {
		return avaliacaoFisica;
	}

	public void setAvaliacaoFisica(List<AvaliacaoBasica> avaliacaoFisica) {
		this.avaliacaoFisica = avaliacaoFisica;
	}

	public Anamnese getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(Anamnese anamnese) {
		this.anamnese = anamnese;
	}

}
