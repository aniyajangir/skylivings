package com.skylivings.webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skylivings.webapp.model.PropertyManager;

public interface ManagerRepo extends JpaRepository<PropertyManager, Integer> {
	@Query("from PropertyManager p where p.user.userId =:userId")
	PropertyManager findPropertyManagerByUserId(long userId);
}
