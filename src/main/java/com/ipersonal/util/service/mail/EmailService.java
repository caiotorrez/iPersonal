package com.ipersonal.util.service.mail;

import org.springframework.mail.SimpleMailMessage;

import com.ipersonal.model.Usuario;

public interface EmailService {
	
	void sendEmailToConfirmationUser(Usuario usuario);
	
	void sendEmailToForgetPassword(Usuario usuario);
	
	void sendEmail(SimpleMailMessage msg);

}
