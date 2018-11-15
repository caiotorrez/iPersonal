package com.ipersonal.v1.endpoint.dto;

import java.io.Serializable;

import com.ipersonal.model.Aluno;
import com.ipersonal.model.Perfil;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Perfil perfil;

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public AlunoDTO(Aluno aluno) {
		this.perfil = aluno.getPerfil();
	}
}
