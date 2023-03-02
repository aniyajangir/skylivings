package com.skylivings.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skylivings.webapp.dto.PropertyDTO;
import com.skylivings.webapp.model.Property;
import com.skylivings.webapp.model.PropertyOwner;
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

//	@PostMapping("/owner")
//	public PropertyOwner setNewOwner(PropertyOwner owner) {
//		return propertyService.addNewOwner(owner);
//	}
}
