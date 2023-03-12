package com.skylivings.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skylivings.webapp.dto.TenantDTO;
import com.skylivings.webapp.model.Tenant;

import com.skylivings.webapp.service.TenantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class TenantController {
	@Autowired
	TenantService tenantService;
	
	@PostMapping("/tenant")
	public TenantDTO addNewTenant(@RequestBody TenantDTO tenant) {
		return tenantService.addTenant(tenant);
	}

	@GetMapping("/tenant-list")
	public List<Tenant> getTenants() {
		List<Tenant> tenants = tenantService.getTenantPersonalDetails();
		return tenants;
	}
	
}
