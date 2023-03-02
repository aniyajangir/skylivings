package com.skylivings.webapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skylivings.webapp.model.User;

public interface UserRepo extends JpaRepository<User, String>{
	User findByUsername(String username);
}
