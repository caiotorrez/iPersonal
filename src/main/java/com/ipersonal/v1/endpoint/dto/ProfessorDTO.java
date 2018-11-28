package com.ipersonal.v1.endpoint.dto;

import java.io.Serializable;

import com.ipersonal.model.Perfil;
import com.ipersonal.model.Professor;

public class ProfessorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String cref;
	private Perfil perfil;

	public ProfessorDTO(Professor professor) {
		this.cref = professor.getCref();
	}

	public String getCref() {
		return cref;
	}

	public void setCref(String cref) {
		this.cref = cref;
	}
	
}
