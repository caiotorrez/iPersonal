package com.ipersonal.config.security;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import com.ipersonal.config.security.filter.JWTAuthenticationFilter;
import com.ipersonal.config.security.filter.JWTAuthorizationFilter;
import com.ipersonal.config.security.service.CustomUserDetailsService;
import com.ipersonal.config.security.token.TokenUtil;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private final CustomUserDetailsService customUserDetailsService;
	private final TokenUtil tokenUtil;
	private static final String[] PUBLIC_MATCHERS = {};
	
	@Autowired
	public SecurityConfig(CustomUserDetailsService customUserDetailsService, TokenUtil tokenUtil) {
		this.customUserDetailsService = customUserDetailsService;
		this.tokenUtil = tokenUtil;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
		.and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers(PUBLIC_MATCHERS).permitAll()
		.antMatchers("/*/admin/**").hasRole("ADMIN")
		.antMatchers("/*/professor/**").hasRole("PROFESSOR")
		.antMatchers("/*/aluno/**").hasRole("ALUNO")
		.and()
		.addFilter(new JWTAuthenticationFilter(this.authenticationManager(), this.tokenUtil))
		.addFilter(new JWTAuthorizationFilter(this.authenticationManager(), this.tokenUtil, this.customUserDetailsService))
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);	
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

}