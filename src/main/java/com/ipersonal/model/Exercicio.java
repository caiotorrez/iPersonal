package com.ipersonal.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Exercicio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private String urlVideo;
	
	@NotNull
	private String urlImagem;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getUrlVideo() {
		return urlVideo;
	}
	
	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}
	
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exercicio other = (Exercicio) obj;
		if (this.nome == null || this.id == null) {
			if (other.nome != null || other.id != null)
				return false;
		} else if (!this.nome.equals(other.nome) || !this.id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Exercicio [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", urlVideo=" + urlVideo
				+ ", urlImagem=" + urlImagem + "]";
	}
	
}
