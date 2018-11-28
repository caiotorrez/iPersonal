package com.ipersonal.util.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.server.ResponseStatusException;

import com.ipersonal.model.Perfil;
import com.ipersonal.model.Usuario;
import com.ipersonal.repository.PerfilRepository;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender")
	private String sender;
	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	public void sendEmailToConfirmationUser(Usuario usuario) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromUser(usuario);
		sendEmail(sm);
	}

	@Override
	public void sendEmailToForgetPassword(Usuario usuario) {
		SimpleMailMessage sm = sendRecoveryPassword(usuario);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromUser(Usuario usuario) {
		SimpleMailMessage sm = new SimpleMailMessage();
		Perfil perfil = this.perfilRepository.findById(usuario.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não Encontrado"));
		sm.setTo(usuario.getEmail());
		sm.setFrom(this.sender);
		sm.setSubject("Confirmação da nova ID no iPersonal");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Olá " + perfil.getNome() + ",\n"
				+ "Esse e-mail é para confirmar a criação da sua conta no iPersonal, clique no link abaixo e em seguida você poderá fazer login!\n\n"
				+ "http://localhost:4200/validation/" + usuario.getIdToEnable() + "\n\n"
				+ "A Equipe do iPersonal de ta boas vindas!");
		return sm;
	}

	protected SimpleMailMessage sendRecoveryPassword(Usuario usuario) {
		SimpleMailMessage sm = new SimpleMailMessage();
		Perfil perfil = this.perfilRepository.findById(usuario.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não Encontrado"));
		sm.setTo(usuario.getEmail());
		sm.setFrom(this.sender);
		sm.setSubject("Solicitação para recuperação da senha no iPersonal");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Olá " + perfil.getNome() + ",\n"
				+ "Esse e-mail foi solicitado por ter esquecido a senha, poderá ser solicitado novamente após 24 horas.\n\n"
				+ "Acesse o link abaixo para criar uma nova senha para sua ID\n"
				+ "http://localhost:4200/recuperar-senha/" + usuario.getChangePasswordId() + "\n\n\nEquipe iPersonal.");
		return sm;
	}

}
