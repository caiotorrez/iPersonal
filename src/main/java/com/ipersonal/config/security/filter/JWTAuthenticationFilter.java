package com.ipersonal.config.security.filter;

import java.io.Serializable;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipersonal.config.security.token.TokenUtil;
import com.ipersonal.model.Usuario;

import io.jsonwebtoken.io.IOException;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final AuthenticationManager authenticationManager;
	private final TokenUtil tokenUtil;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, TokenUtil tokenUtil) {
		this.authenticationManager = authenticationManager;
		this.tokenUtil = tokenUtil;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		
		try {
			Credenciais usuario = new ObjectMapper().readValue(request.getInputStream(), Credenciais.class);
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getPassword());
			this.setDetails(request, authToken);
			return this.authenticationManager.authenticate(authToken);
			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException, java.io.IOException {
		
		Usuario usuario = (Usuario) authResult.getPrincipal();
		String username = usuario.getEmail();
		String accessType = usuario.getProfessor() == null ? "aluno" : "professor";
		String token = this.tokenUtil.buildJwtToken(username, accessType);
		response.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
	}
	
	private static class Credenciais {
		
		private String email;
		private String password;
		
		public String getEmail() {
			return email;
		}

		public String getPassword() {
			return password;
		}
	}

}
