package com.skylivings.webapp.model;

import lombok.Data;

@Data
public class JwtResponse {
	
	private User user;
	private String jwtToken;
	
	public JwtResponse(User user, String jwtToken) {
		super();
		this.user = user;
		this.jwtToken = jwtToken;
	}
	
	
}
