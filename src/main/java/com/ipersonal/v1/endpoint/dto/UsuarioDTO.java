package com.ipersonal.v1.endpoint.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "O email não pode ser em branco")
	@Email(message = "O email tem que ser válido")
	private String email;

	@NotNull(message = "O password do usuário não pode ser em branco")
	private String password;

	private String idToEnable;
	private String changePasswordId;
	private Date changePasswordDateTime;
	private Date forgotPasswordDateTime;

	public UsuarioDTO(String email, String password) {
		this.email = email;
		this.password = password;
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

	public String getIdToEnable() {
		return idToEnable;
	}

	public void setIdToEnable(String idOfEnable) {
		this.idToEnable = idOfEnable;
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

	@Override
	public String toString() {
		return "UsuarioDTO [email=" + email + ", password=" + password + ", idToEnable=" + idToEnable + "]";
	}

}
