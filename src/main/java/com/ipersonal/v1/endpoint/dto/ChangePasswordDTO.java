package com.ipersonal.v1.endpoint.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class ChangePasswordDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String changePasswordId;
	private String password;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChangePasswordId() {
		return changePasswordId;
	}
	public void setChangePasswordId(String changePasswordId) {
		this.changePasswordId = changePasswordId;
	}
	
}
