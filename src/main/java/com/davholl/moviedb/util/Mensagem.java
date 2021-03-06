package com.davholl.moviedb.util;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class Mensagem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3615822399208264013L;
	
	public Mensagem() {}

	public Mensagem(HttpStatus status) {
		this.statusCode = String.valueOf(status.value());
		this.statusMessage = status.getReasonPhrase();
	}
	
	String statusMessage;
	
	String statusCode;

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
