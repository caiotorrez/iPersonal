package com.ipersonal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario extends EntidadeBase {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "O email não pode ser em branco")
	@Email(message = "O email tem que ser válido")
	@Column(unique = true)
	protected String email;

	@NotNull(message = "O password do usuário não pode ser em branco")
	private String password;

	private Aluno aluno;
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Professor professor;
	
	public Usuario() {
	}
	
	public Usuario(Usuario usuario) {
		this.password = usuario.getPassword();
		this.email = usuario.getEmail();
		this.professor = usuario.getProfessor();
		this.aluno = usuario.getAluno();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
