package com.skylivings.webapp.model;

import lombok.Data;

@Data
public class JwtRequest {
	
	private String userName;
	private String userPassword;
	
	public JwtRequest(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	
	}
