package com.skylivings.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skylivings.webapp.dto.ManagerDTO;
import com.skylivings.webapp.model.PropertyManager;
import com.skylivings.webapp.service.ManagerService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	
	
	@PostMapping("/manager")
	public ManagerDTO addNewManager(@RequestBody ManagerDTO manager) {
		return managerService.addNewManager(manager);
	}
	
	@GetMapping("/manager-list")
	public List<PropertyManager> getManagerList() {
		return managerService.getManagerList();
	}
}
