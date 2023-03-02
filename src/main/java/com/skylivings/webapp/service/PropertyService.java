package com.skylivings.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.skylivings.webapp.dto.PropertyDTO;
import com.skylivings.webapp.dto.TenantDTO;
import com.skylivings.webapp.model.Address;
import com.skylivings.webapp.model.Property;
import com.skylivings.webapp.model.PropertyManager;
import com.skylivings.webapp.model.PropertyOwner;
import com.skylivings.webapp.model.Room;
import com.skylivings.webapp.repo.ManagerRepo;
import com.skylivings.webapp.repo.OwnerRepo;
import com.skylivings.webapp.repo.PropertyRepo;
import com.skylivings.webapp.repo.RoomRepo;

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
	
	public PropertyDTO addNewProperty(PropertyDTO propertyDTO) {
		Property property = new Property();
		property.setPropertyCode(propertyDTO.getPropertyCode());
		property.setPropertyName(propertyDTO.getPropertyName());
		property.setPropertyType(propertyDTO.getPropertyType());
		property.setPropertyStatus(propertyDTO.getPropertyStatus());
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
		
		int managerId = propertyDTO.getManager().getManagerId();
		PropertyManager manager = managerRepo.getById(managerId);
		
		property.setManager(manager);
		
		property.setOwner(owner);
		
		propertyRepo.save(property);
		return propertyDTO;
	}
	
	public List<Property> getPropertyList(){
		return propertyRepo.findAll();
	}
	
}

