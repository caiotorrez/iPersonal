package com.ipersonal.v1.endpoint.dto;

import java.io.Serializable;

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

	@Override
	public String toString() {
		return "UsuarioDTO [email=" + email + ", password=" + password + ", idToEnable=" + "]";
	}

}
