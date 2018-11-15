package com.ipersonal.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class BaseException implements Serializable {
	private static final long serialVersionUID = 1L;

	private HttpStatus status;
	private String error;
	private String message;
	private String path;
	
	public BaseException(HttpStatus status, String error, String message, String path) {
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public void setStatus(HttpStatus status) {
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
