package com.ipersonal.exception;

import java.io.Serializable;

public class BaseException implements Serializable {
	private static final long serialVersionUID = 1L;

	private String status;
	private String error;
	private String message;
	private String path;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	

}
