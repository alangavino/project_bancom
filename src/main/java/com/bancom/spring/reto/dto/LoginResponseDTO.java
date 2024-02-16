package com.bancom.spring.reto.dto;

public class LoginResponseDTO {

	private String accesTtoken;
	private String typeToken;
	
	public LoginResponseDTO(String accesTtoken) {	
		this.accesTtoken = accesTtoken;
		this.typeToken="Bearer";
	}

	public String getAccesTtoken() {
		return accesTtoken;
	}

	public void setAccesTtoken(String accesTtoken) {
		this.accesTtoken = accesTtoken;
	}

	public String getTypeToken() {
		return typeToken;
	}

	public void setTypeToken(String typeToken) {
		this.typeToken = typeToken;
	}
	
	
}
