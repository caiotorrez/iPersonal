package com.ipersonal.config.security.service;

import java.util.Collection;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.ipersonal.model.Usuario;

public class CustomUserDetails extends Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private final String role;
	
	public CustomUserDetails(Usuario usuario) {
		super(usuario);
		this.role = this.getProfessor() == null ? "ROLE_ALUNO" : "ROLE_ADMIN";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.isAccountNonLocked() && this.isAccountNonExpired() && this.isCredentialsNonExpired() && this.isEnabled()) {
			return AuthorityUtils.createAuthorityList(this.role);
		}
		throw new AccessDeniedException("Acesso negado");
	}
	
	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.enabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.enabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.enabled;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

}
