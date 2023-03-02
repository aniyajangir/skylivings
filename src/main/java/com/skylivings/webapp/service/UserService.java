package com.skylivings.webapp.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylivings.webapp.model.Role;
import com.skylivings.webapp.model.User;
import com.skylivings.webapp.repo.RoleRepo;
import com.skylivings.webapp.repo.UserRepo;

@Service
public class UserService {
//	User user = new User();
//	Role role = new Role();
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	public List<User> getUserList(){
		return userRepo.findAll();
	}
	
	public User registerNewUser(User user)
	{
		Role userRole = roleRepo.findByRoleName("USER");
		user.setRole(userRole);
		user.setUsername(user.getUsername());
		user.setUserPassword(user.getUserPassword());
		return userRepo.save(user);
	}
	
	
	public void initRolesAndUser() {
		System.out.println("Hiiii");
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("By Default Admin");
		roleRepo.save(adminRole);
		
		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for new user");
		roleRepo.save(userRole);
		
		User adminUser = new User();
		adminUser.setUsername("admin");
		adminUser.setUserPassword("$2a$12$BvPjotTO9QLuPJ8zrX.Q5u6YbeS/NODRfjfEtZSgrQd2cBRcjAXwO");
		adminUser.setRole(adminRole);
		userRepo.save(adminUser);	
		
		User demoUser = new User();
		demoUser.setUsername("Anil_Jangir");
		demoUser.setUserPassword("$2a$12$BvPjotTO9QLuPJ8zrX.Q5u6YbeS/NODRfjfEtZSgrQd2cBRcjAXwO");
		demoUser.setRole(userRole);
		userRepo.save(demoUser);
	}
	
	public void registerUser(User user) {
		userRepo.save(user);
	}
	
}
