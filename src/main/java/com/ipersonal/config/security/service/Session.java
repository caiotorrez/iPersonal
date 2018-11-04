package com.ipersonal.config.security.service;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;

import com.ipersonal.model.Usuario;

public class Session {	
	
	public static boolean Autenticado() {
		return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
				.orElseThrow(() -> new SecurityException("Acesso negado"));
	}
	
	public static Usuario getUserLogged() { 
		return (Usuario) Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.orElseThrow(() -> new SecurityException("Acesso negado"));
	}
}
