package com.ipersonal.v1.endpoint.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CadastroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private UsuarioDTO usuario;
	@NotNull
	private PerfilDTO perfil;
	private String cref;

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}

	@Override
	public String toString() {
		return "CadastroDTO [usuario=" + usuario + ", perfil=" + perfil + ", cref=" + cref + "]";
	}

}
