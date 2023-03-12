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

import com.skylivings.webapp.dto.ManagerDTO;
import com.skylivings.webapp.dto.TenantCheckoutDTO;
import com.skylivings.webapp.dto.TenantDTO;
import com.skylivings.webapp.model.PropertyManager;
import com.skylivings.webapp.model.Tenant;
import com.skylivings.webapp.service.ManagerService;
import com.skylivings.webapp.service.TenantService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@Autowired
	private TenantService tenantService;
	
	@PostMapping("/manager")
	public ManagerDTO addNewManager(@RequestBody ManagerDTO manager) {
		return managerService.addNewManager(manager);
	}
	
	@GetMapping("/manager-list")
	public List<PropertyManager> getManagerList() {
		return managerService.getManagerList();
	}
	
	@PostMapping("/checkout-tenant")
	public Tenant checkoutTenant(@RequestBody TenantCheckoutDTO checkoutDTO) {
		return managerService.checkoutTenant(checkoutDTO);
	}
	
	@GetMapping("/active-tenants")
	public List<Tenant> getActiveTenantList(){
		return tenantService.getActiveTenantList();
	}
	
	@GetMapping("/get-tenant")
	public TenantDTO getTenantById(@RequestParam int tenantId) {
		return tenantService.getTenantById(tenantId);
	}
	
	@GetMapping("/get-roommates")
	public List<Tenant> getRoomMatesById(@RequestParam int tenantId) {
		return tenantService.getRoomMatesList(tenantId);
	}
	
	
}
