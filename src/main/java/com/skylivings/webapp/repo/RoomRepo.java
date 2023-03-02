package com.skylivings.webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skylivings.webapp.model.Room;

public interface RoomRepo extends JpaRepository<Room, Long>{

}
