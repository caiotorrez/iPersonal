package com.ipersonal.v1.endpoint.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ValidationRegisterDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String idToEnable;

	public String getIdToEnable() {
		return idToEnable;
	}

	public void setIdToEnable(String idToEnable) {
		this.idToEnable = idToEnable;
	}

}
