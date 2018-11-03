package com.ipersonal.config.security.filter;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.ipersonal.config.security.service.CustomUserDetailsService;
import com.ipersonal.config.security.token.TokenUtil;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final TokenUtil tokenUtil;
	private final CustomUserDetailsService detailsService;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, 
			TokenUtil tokenUtil, CustomUserDetailsService detailsService) {
		super(authenticationManager);
		this.tokenUtil = tokenUtil;
		this.detailsService = detailsService;
	}

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (token != null && token.startsWith("Bearer ")) {
			UsernamePasswordAuthenticationToken auth = getAuthentication(request, token);
			if (auth != null) {
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		chain.doFilter(request, response);
	}


	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, String token) {
		if (this.tokenUtil.tokenIsValid(token)) {
			String username = this.tokenUtil.getUsername(token);
			UserDetails userDetails = this.detailsService.loadUserByUsername(username);
			return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		}
		return null;
	}
}
