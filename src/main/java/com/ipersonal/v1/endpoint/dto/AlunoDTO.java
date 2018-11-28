package com.ipersonal.v1.endpoint.dto;

import java.io.Serializable;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	private PerfilDTO perfil;
	
	public AlunoDTO(String email, String password, PerfilDTO perfil) {
		super();
		this.email = email;
		this.password = password;
		this.perfil = perfil;
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
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
		return "AlunoDTO [email=" + email + ", password=" + password + ", perfil=" + perfil + "]";
	}
	
}
