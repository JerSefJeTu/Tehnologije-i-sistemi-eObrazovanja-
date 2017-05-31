package com.ap.web.dto;

public class TokenDTO {

	String payload;

	
	
	public TokenDTO() {
		super();
	}

	public TokenDTO(String payload) {
		super();
		this.payload = payload;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
	
	
}
