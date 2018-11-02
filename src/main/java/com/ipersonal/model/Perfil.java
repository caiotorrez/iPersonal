package com.ipersonal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Perfil extends EntidadeBase {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "O primeiro nome não pode ser em branco")
	@Length(min = 3, max = 40, message = "Deve ser no mínimo 5 e no máximo 40 caractérs")
	private String primeiroNome;

	@NotEmpty(message = "O segundo nome não pode ser em branco")
	@Length(min = 3, max = 40, message = "Deve ser no mínimo 5 e no máximo 40 caractérs")
	private String segundoNome;
	
	@NotEmpty(message = "O email não pode ser em branco")
	@Email(message = "O email tem que ser válido")
	@Column(unique = true)
	private String email;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotEmpty(message = "A data não pode ser em branco")
	private Date nascimento;

	@NotEmpty(message = "O cep não pode ser em branco")
	@Pattern(regexp = "[0-9]{5}-[0-9]{3}")
	private String cep;

	@NotEmpty(message = "O número do celular não pode ser em branco")
	private String celphone;

	public Perfil(String primeiroNome,String segundoNome, String email,
			Date nascimento,String cep, String celphone) {
		this.primeiroNome = primeiroNome;
		this.segundoNome = segundoNome;
		this.email = email;
		this.nascimento = nascimento;
		this.cep = cep;
		this.celphone = celphone;
	}
	
	public Perfil() {
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSegundoNome() {
		return segundoNome;
	}

	public void setSegundoNome(String segundoNome) {
		this.segundoNome = segundoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCelphone() {
		return celphone;
	}

	public void setCelphone(String celphone) {
		this.celphone = celphone;
	}

	@Override
	public String toString() {
		return "Credenciais [primeiroNome=" + primeiroNome + ", segundoNome=" + segundoNome + ", email=" + email
				+ ", nascimento=" + nascimento + ", cep=" + cep + ", celphone=" + celphone + "]";
	}
}
