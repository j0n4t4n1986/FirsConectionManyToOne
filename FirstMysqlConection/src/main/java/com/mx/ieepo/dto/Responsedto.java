package com.mx.ieepo.dto;

import org.springframework.http.HttpStatus;

public class Responsedto {
	
	private Object body;
	private HttpStatus status;
	private String message;
	
	
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	

}
