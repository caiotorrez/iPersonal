package com.ipersonal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Professor extends EntidadeBase {

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Credenciais credenciais;
	
	@OneToMany
	private List<Usuario> usuarios = new ArrayList<>();
	
	@NotNull(message = "O CREF não pode ser em branco")
	private String cref;
	
	public Professor() {
	}
	
	public Professor(Credenciais credenciais, String cref) {
		this.credenciais = credenciais;
		this.cref = cref;
	}

	public Credenciais getCredenciais() {
		return credenciais;
	}

	public void setCredenciais(Credenciais credenciais) {
		this.credenciais = credenciais;
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}
	
}
