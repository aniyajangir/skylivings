package com.skylivings.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skylivings.webapp.dto.PropertyDTO;
import com.skylivings.webapp.dto.RoomDTO;
import com.skylivings.webapp.model.Property;
import com.skylivings.webapp.model.Room;
import com.skylivings.webapp.model.Tenant;
import com.skylivings.webapp.service.PropertyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class AdminController {
		
	@Autowired
	PropertyService propertyService;

	
	@GetMapping("/manager")
	public String getManagerPage() {
		return "register-manager";
	}
	
	@PostMapping("/property")
	public PropertyDTO onBoardNewProperty(@RequestBody PropertyDTO property) {
		System.out.println(property);
		return propertyService.addNewProperty(property);
	}
	
	@GetMapping("/property-list")
	public List<Property> getPropertyList() {
		 return propertyService.getPropertyList();
	}
	
	@PostMapping("/room")
	public Room newPropertyRoom(@RequestBody RoomDTO roomDTO) {
		return propertyService.addNewRoom(roomDTO);
	}
	
	@GetMapping("/available-rooms")
	public List<Room> getRoomList(@RequestParam int propertyId){
		return propertyService.getRoomsOfProperty(propertyId);
	}
	
	@GetMapping("/property-room-rent")
	public double getPropertyRoomRent(@RequestParam int propertyId, @RequestParam int roomId) {
		return propertyService.getPropertyRoomRent(propertyId, roomId);
	}
	
	@GetMapping("/property-room-tenants")
	public List<Tenant> getPropertyRoomTenants(@RequestParam int propertyId, @RequestParam int roomId){
		return propertyService.getRoomTenants(propertyId, roomId);
	}
	
	@GetMapping("/property-room-deposit")
	public double getPropertyRoomDeposit(@RequestParam int roomId) {
		return propertyService.getPropertyRoomDeposit(roomId);
	}
	

}
