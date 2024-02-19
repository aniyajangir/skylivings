package com.skylivings.webapp.model;

import lombok.Data;

@Data
public class JwtRequest {
	//Username
	private String userName;
	private String userPassword;
	private String userRole;
	
	public JwtRequest(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	
	}
