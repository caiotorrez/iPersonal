package com.ipersonal.v1.endpoint.service;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ipersonal.model.Aluno;
import com.ipersonal.model.Perfil;
import com.ipersonal.model.Usuario;
import com.ipersonal.repository.AlunoRepository;
import com.ipersonal.repository.PerfilRepository;
import com.ipersonal.repository.UsuarioRepository;
import com.ipersonal.util.service.mail.EmailService;
import com.ipersonal.v1.endpoint.dto.CadastroDTO;
import com.ipersonal.v1.endpoint.dto.ChangePasswordDTO;
import com.ipersonal.v1.endpoint.dto.PerfilDTO;
import com.ipersonal.v1.endpoint.dto.UsuarioDTO;

import net.bytebuddy.utility.RandomString;

@Service
public class CadastroService implements Serializable {
	private static final long serialVersionUID = 1L;

	private final PerfilRepository perfilRepository;
	private final UsuarioRepository usuarioRepository;
	private final AlunoRepository alunoRepository;
	private EmailService emailService;

	@Autowired
	public CadastroService(PerfilRepository perfilRepository, UsuarioRepository usuarioRepository,
			AlunoRepository alunoRepository, EmailService emailService) {
		this.perfilRepository = perfilRepository;
		this.usuarioRepository = usuarioRepository;
		this.alunoRepository = alunoRepository;
		this.emailService = emailService;
	}

	private Usuario buildUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario(usuarioDTO.getEmail(),
				new BCryptPasswordEncoder().encode(usuarioDTO.getPassword()));
		usuario.setIdToEnable(RandomString.make(180));
		return usuario;
	}

	private Perfil buildPerfil(PerfilDTO perfilDTO, Usuario usuario) {
		String nome = perfilDTO.getNome().substring(0, 1).toUpperCase() + perfilDTO.getNome().substring(1);
		String sobrenome = perfilDTO.getSobrenome().substring(0, 1).toUpperCase()
				+ perfilDTO.getSobrenome().substring(1);
		Perfil perfil = new Perfil(nome, sobrenome, Date.from(Instant.parse(perfilDTO.getNascimento())),
				perfilDTO.getCep(), perfilDTO.getCelular());
		perfil.setUsuario(usuario);
		return perfil;
	}

	public Aluno register(CadastroDTO cadastro) {
		Usuario usuario = this.usuarioRepository.save(this.buildUsuario(cadastro.getUsuario()));
		usuario.setIdToEnable(usuario.getIdToEnable() + RandomString.hashOf(usuario.getId().intValue()));
		usuario = this.usuarioRepository.save(usuario);
		Perfil perfil = this.perfilRepository.save(this.buildPerfil(cadastro.getPerfil(), usuario));
		Aluno aluno = this.alunoRepository.save(new Aluno(usuario));
		usuario.setPerfil(perfil);
		this.emailService.sendEmailToConfirmationUser(usuario);
		return aluno;
	}

	public UsuarioDTO recoveryPassword(UsuarioDTO usuarioDTO) {
		Usuario usuario = this.usuarioRepository.findByEmail(usuarioDTO.getEmail())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		Date usuarioForgotDateTime = usuario.getForgotPasswordDateTime();
		new Date();
		if (usuarioForgotDateTime != null) {
			return null;
		}
		usuario.setForgotPasswordDateTime(Date.from(Instant.now().plusSeconds(86400)));
		String key = RandomString.hashOf(usuario.getId().intValue()) + RandomString.make(200);
		usuario.setChangePasswordId(key);
		this.emailService.sendEmailToForgetPassword(usuario);
		this.usuarioRepository.save(usuario);
		return usuarioDTO;
	}

	public ChangePasswordDTO changePassword(ChangePasswordDTO validation) {
		Usuario usuario = this.usuarioRepository.findByChangePasswordId(validation.getChangePasswordId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		new Date();
		if (usuario.getForgotPasswordDateTime() == null || usuario.getChangePasswordId() == null ||
				usuario.getForgotPasswordDateTime().before(Date.from(Instant.now()))) {
			return null;
		}
		usuario.setPassword(new BCryptPasswordEncoder().encode(validation.getPassword()));
		usuario.setChangePasswordDateTime(Date.from(Instant.now()));
		usuario.setForgotPasswordDateTime(null);
		usuario.setChangePasswordId(null);
		this.usuarioRepository.save(usuario);
		validation.setPassword(null);
		return validation;
	}

}
