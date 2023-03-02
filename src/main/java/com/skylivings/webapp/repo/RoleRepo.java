package com.skylivings.webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skylivings.webapp.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{
	Role findByRoleName(String role);
}
