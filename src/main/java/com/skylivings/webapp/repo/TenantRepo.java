package com.skylivings.webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skylivings.webapp.model.Tenant;

public interface TenantRepo extends JpaRepository<Tenant, Long> {
	
	Tenant findTenantById(long id);
}
