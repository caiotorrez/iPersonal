package com.ipersonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ipersonal.util.service.mail.EmailService;
import com.ipersonal.util.service.mail.SmtpEmailService;

@Configuration
public class BeanConfigs {
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
	

}
