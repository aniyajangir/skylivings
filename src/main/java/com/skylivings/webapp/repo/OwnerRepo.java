package com.skylivings.webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skylivings.webapp.model.PropertyOwner;

public interface OwnerRepo extends JpaRepository<PropertyOwner, Integer> {

}
