package com.ipersonal.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario extends EntidadeBase {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "O nome do usuário não pode ser em branco")
	private String username;

	@NotNull(message = "O password do usuário não pode ser em branco")
	private String password;

	@OneToOne
	private Aluno aluno;
	
	@OneToOne
	private Professor professor;
	
	

}
