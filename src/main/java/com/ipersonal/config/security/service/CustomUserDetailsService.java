package com.ipersonal.config.security.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ipersonal.model.Usuario;
import com.ipersonal.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService, Serializable {
	private static final long serialVersionUID = 1L;

	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
		return new CustomUserDetails(usuario);
	}
}
