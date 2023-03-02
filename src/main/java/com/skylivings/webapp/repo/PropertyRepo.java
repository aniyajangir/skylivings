package com.skylivings.webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skylivings.webapp.model.Property;

public interface PropertyRepo extends JpaRepository<Property, Integer> {
	
}
