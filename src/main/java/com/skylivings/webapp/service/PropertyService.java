package com.skylivings.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.skylivings.webapp.dto.PropertyDTO;
import com.skylivings.webapp.dto.RoomDTO;
import com.skylivings.webapp.dto.TenantDTO;
import com.skylivings.webapp.model.Address;
import com.skylivings.webapp.model.Property;
import com.skylivings.webapp.model.PropertyManager;
import com.skylivings.webapp.model.PropertyOwner;
import com.skylivings.webapp.model.Room;
import com.skylivings.webapp.model.Tenant;
import com.skylivings.webapp.model.enums.PropertyStatus;
import com.skylivings.webapp.model.enums.RoomStatus;
import com.skylivings.webapp.repo.ManagerRepo;
import com.skylivings.webapp.repo.OwnerRepo;
import com.skylivings.webapp.repo.PropertyRepo;
import com.skylivings.webapp.repo.RoomRepo;
import com.skylivings.webapp.repo.TenantRepo;

import lombok.val;

@Service
public class PropertyService {
	@Autowired
	private PropertyRepo propertyRepo;
	
	@Autowired
	private RoomRepo roomRepo;
	
	@Autowired
	private OwnerRepo ownerRepo;
	
	@Autowired
	private ManagerRepo managerRepo;
	
	@Autowired
	private TenantRepo tenantRepo;
	
	public PropertyDTO addNewProperty(PropertyDTO propertyDTO) {
		Property property = new Property();
		property.setPropertyCode(propertyDTO.getPropertyCode());
		property.setPropertyName(propertyDTO.getPropertyName());
		property.setPropertyType(propertyDTO.getPropertyType());
		property.setPropertyStatus(PropertyStatus.ACTIVE);
		property.setOnBoardingDate(propertyDTO.getOnBoardingDate());
		
		Address address = new Address();
		address.setFlatNumber(propertyDTO.getFirstName());
		address.setStreetName(propertyDTO.getStreetName());
		address.setCity(propertyDTO.getCity());
		address.setState(propertyDTO.getState());
		address.setPincode(propertyDTO.getZip());
		address.setCountry(propertyDTO.getCountry());
		
		property.setAddress(address);
		
		PropertyOwner owner = new PropertyOwner();
		owner.setFirstName(propertyDTO.getFirstName());
		owner.setLastName(propertyDTO.getLastName());
		owner.setContact(propertyDTO.getContact());
		owner.setEmail(propertyDTO.getEmail());
		owner.setAlternativeContact(propertyDTO.getAlternativeContact());
		owner.setGender(propertyDTO.getGender());
		
		int managerId = propertyDTO.getManagerId();
		PropertyManager manager = managerRepo.getById(managerId);
		
		property.setManager(manager);
		
		property.setOwner(owner);
		
		List<RoomDTO> roomDTOs = propertyDTO.getRooms();
		
		List<Room> rooms = new ArrayList<>();
		
		for(int i = 0; i<roomDTOs.size(); i++) {
			Room room = new Room();
			room = addNewRoom(roomDTOs.get(i));
			rooms.add(room);
		}
		
		property.setRooms(rooms);
		
 		propertyRepo.save(property);
		return propertyDTO;
	}
	
	public List<Property> getPropertyList(){
		return propertyRepo.findAll();
	}
	
	public Room addNewRoom(RoomDTO roomDTO) {
			Room room = new Room();
			room.setRoomNumber(roomDTO.getRoomNumber());
			room.setPropertyType(roomDTO.getRoomType());
			room.setRoomStatus(RoomStatus.VACANT);
			room.setDeposit(roomDTO.getDeposit());
			room.setNumberOfBedrooms(roomDTO.getBedrooms());
			room.setNumberOrBathrooms(roomDTO.getBathrooms());
			room.setRent(roomDTO.getRent());
			room.setDesctiption(roomDTO.getDescription());
			room.setCapacity(roomDTO.getCapacity());
			return room;
	}
	
	public List<Room> getRoomsOfProperty(int propertyId){
		List<Room> propertyRooms = new ArrayList<>();
		List<Property> properties = getPropertyList();
		for(int i = 0; i<properties.size(); i++) {
			if(propertyId == properties.get(i).getPropertyId()) {
				return properties.get(i).getRooms();
			}
		}
		return propertyRooms;
	}
	
	public double getPropertyRoomRent(int propertyId, int roomId) {
		Property property = propertyRepo.getById(propertyId);
		List<Room> rooms = property.getRooms();
		double rent = 0.0;
		for(int i =0; i<rooms.size(); i++) {
			if(roomId == rooms.get(i).getRoomId()) {
				rent = rooms.get(i).getRent();
			}
		}
		return rent;
	}
	
	public double getPropertyRoomDeposit(int roomId) {
		Room room = roomRepo.getById(roomId);
		return room.getDeposit();
	}
	
	public List<Tenant> getRoomTenants(int propertyId, int roomId){
		Property property = propertyRepo.getById(propertyId);
		List<Tenant> tenants = tenantRepo.getTenantByRoom(roomId);
		return tenants;
	}

 	
	public boolean isNumeric(String string) {
	    int intValue;
			
	    System.out.println(String.format("Parsing string: \"%s\"", string));
			
	    if(string == null || string.equals("")) {
	        System.out.println("String cannot be parsed, it is null or empty.");
	        return false;
	    }
	    
	    try {
	        intValue = Integer.parseInt(string);
	        return true;
	    } catch (NumberFormatException e) {
	        System.out.println("Input String cannot be parsed to Integer.");
	    }
	    return false;
}
}
