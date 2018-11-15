package com.ipersonal.v1.endpoint.service;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipersonal.model.Aluno;
import com.ipersonal.model.Perfil;
import com.ipersonal.model.Usuario;
import com.ipersonal.repository.AlunoRepository;
import com.ipersonal.repository.PerfilRepository;
import com.ipersonal.repository.UsuarioRepository;

@Service
public class AlunoService implements Serializable {
	private static final long serialVersionUID = 1L;

	private final PerfilRepository perfilRepository;
	private final UsuarioRepository usuarioRepository;
	private final AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoService(PerfilRepository perfilRepository, UsuarioRepository usuarioRepository, AlunoRepository alunoRepository) {
		this.perfilRepository = perfilRepository;
		this.usuarioRepository = usuarioRepository;
		this.alunoRepository = alunoRepository;
	}
	
	public Aluno register(Usuario usuario, Perfil perfil) {
		Aluno aluno = new Aluno();
		usuario = this.usuarioRepository.save(usuario);
		perfil = this.perfilRepository.save(perfil);
		aluno.setUsuario(usuario);
		aluno.setPerfil(perfil);
		return this.alunoRepository.save(aluno);
	}
}
