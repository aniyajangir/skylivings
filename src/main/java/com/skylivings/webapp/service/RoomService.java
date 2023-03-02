package com.skylivings.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylivings.webapp.model.Room;
import com.skylivings.webapp.repo.RoomRepo;

@Service
public class RoomService {
	@Autowired
	RoomRepo roomRepo;
	
	public Room newRoom(Room room) {
		return roomRepo.save(room);
	}
}
