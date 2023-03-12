package com.skylivings.webapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skylivings.webapp.model.Room;
import com.skylivings.webapp.model.Tenant;

public interface RoomRepo extends JpaRepository<Room, Integer>{
//	@Query("SELECT ")
//	int getRoomIdByTenantId();

}
