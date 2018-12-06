package com.ipersonal.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario extends EntidadeBase {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "O email não pode ser em branco")
	@Email(message = "O email tem que ser válido")
	@Column(unique = true)
	protected String email;

	@NotNull(message = "O password do usuário não pode ser em branco")
	private String password;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Perfil perfil;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Professor professor;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Aluno aluno;

	@Column(unique = true)
	private String idToEnable;
	
	@Column(unique = true)
	private String changePasswordId;
	
	private Date changePasswordDateTime;
	
	private Date forgotPasswordDateTime;

	public Usuario() {
	}

	public Usuario(Usuario usuario) {
		this.password = usuario.getPassword();
		this.email = usuario.getEmail();
		this.enabled = usuario.isEnabled();
	}

	public Usuario(String email, String password) {
		this.email = email;
		this.password = password;
	}

	@JsonIgnore
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getIdToEnable() {
		return idToEnable;
	}

	public void setIdToEnable(String idToEnable) {
		this.idToEnable = idToEnable;
	}

	public String getChangePasswordId() {
		return changePasswordId;
	}

	public void setChangePasswordId(String changePasswordId) {
		this.changePasswordId = changePasswordId;
	}

	public Date getChangePasswordDateTime() {
		return changePasswordDateTime;
	}

	public void setChangePasswordDateTime(Date changePasswordDateTime) {
		this.changePasswordDateTime = changePasswordDateTime;
	}

	public Date getForgotPasswordDateTime() {
		return forgotPasswordDateTime;
	}

	public void setForgotPasswordDateTime(Date forgotPasswordDateTime) {
		this.forgotPasswordDateTime = forgotPasswordDateTime;
	}
}
