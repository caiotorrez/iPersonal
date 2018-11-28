package com.ipersonal.v1.endpoint.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class PerfilDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "O primeiro nome não pode ser em branco")
	@Length(min = 3, max = 40, message = "Deve ser no mínimo 5 e no máximo 40 caractérs")
	private String nome;

	@NotEmpty(message = "O segundo nome não pode ser em branco")
	@Length(min = 3, max = 40, message = "Deve ser no mínimo 5 e no máximo 40 caractérs")
	private String sobrenome;

	@NotEmpty(message = "A data não pode ser em branco")
	private String nascimento;

	@NotEmpty(message = "O cep não pode ser em branco")
	@Pattern(regexp = "[0-9]{5}-[0-9]{3}")
	private String cep;

	@NotEmpty(message = "O número do celular não pode ser em branco")
	private String celular;

	public PerfilDTO() {
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

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "PerfilDTO [nome=" + nome + ", sobrenome=" + sobrenome + ", nascimento=" + nascimento + ", cep=" + cep
				+ ", celphone=" + celular + "]";
	}

}
