package com.ipersonal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Perfil extends EntidadeFilha {
	private static final long serialVersionUID = 1L;

	@OneToOne
	@MapsId
	private Usuario usuario;

	@NotEmpty(message = "O primeiro nome não pode ser em branco")
	@Length(min = 3, max = 40, message = "Deve ser no mínimo 5 e no máximo 40 caractérs")
	private String nome;

	@NotEmpty(message = "O segundo nome não pode ser em branco")
	@Length(min = 3, max = 40, message = "Deve ser no mínimo 5 e no máximo 40 caractérs")
	private String sobrenome;

	@DateTimeFormat
	private Date nascimento;

	@NotEmpty(message = "O cep não pode ser em branco")
	@Pattern(regexp = "[0-9]{5}-[0-9]{3}")
	private String cep;

	@NotEmpty(message = "O número do celular não pode ser em branco")
	private String celphone;

	public Perfil(String nome, String sobrenome, Date nascimento, String cep, String celphone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nascimento = nascimento;
		this.cep = cep;
		this.celphone = celphone;
	}

	public Perfil() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@JsonFormat(pattern = "dd/MM/yyyy")
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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Credenciais [primeiroNome=" + nome + ", segundoNome=" + sobrenome + ", nascimento=" + nascimento
				+ ", cep=" + cep + ", celphone=" + celphone + "]";
	}
}
