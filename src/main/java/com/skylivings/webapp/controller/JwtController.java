//package com.skylivings.webapp.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.skylivings.webapp.model.JwtRequest;
//import com.skylivings.webapp.model.JwtResponse;
//import com.skylivings.webapp.service.JwtService;
//
//@RestController
//@CrossOrigin
//public class JwtController {
//	
//	@Autowired
//	private JwtService jwtService;
//	
//	@PostMapping({"/authenticate"})
//	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception
//	{
//		return jwtService.createJwtToken(jwtRequest);
//	}
//}
