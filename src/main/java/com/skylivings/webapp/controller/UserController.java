package com.skylivings.webapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skylivings.webapp.model.User;
import com.skylivings.webapp.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@PostConstruct
//	public void initRolesAndUsers()
//	{
//		userService.initRolesAndUser();
//	}
	
	@PostMapping("/user")
	public User registerNewUser(@RequestBody User user)
	{
		System.out.println("Reached to Register Controller");
		return userService.registerNewUser(user);
	}
	


}
