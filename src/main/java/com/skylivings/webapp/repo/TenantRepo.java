package com.skylivings.webapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.skylivings.webapp.model.Tenant;

public interface TenantRepo extends JpaRepository<Tenant, Integer> {
	
//	@Modifying
//	@Query("update Tenant t set t.tenantStatus = '' where u.id = ?3")
//	void setUserInfoById(String firstname, String lastname, Integer userId);
	@Query(value = "SELECT * FROM tenant WHERE tenant_status = 'ACTIVE' ", nativeQuery = true)
	List<Tenant> getActiveTenantList();
	
	@Query("SELECT t FROM Tenant t WHERE t.room.roomId = ?1")
	List<Tenant> getTenantByRoom(int roomId);
}
