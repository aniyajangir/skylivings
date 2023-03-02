package com.skylivings.webapp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylivings.webapp.model.Role;
import com.skylivings.webapp.repo.RoleRepo;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepo roleRepo;
	
	public Role createNewRole(Role role)
	{
		return roleRepo.save(role);
	}
}
