package com.skylivings.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylivings.webapp.dto.ManagerDTO;
import com.skylivings.webapp.dto.TenantCheckoutDTO;
import com.skylivings.webapp.model.Address;
import com.skylivings.webapp.model.PropertyManager;
import com.skylivings.webapp.model.Role;
import com.skylivings.webapp.model.Tenant;
import com.skylivings.webapp.model.User;
import com.skylivings.webapp.model.enums.TenantStatus;
import com.skylivings.webapp.repo.AddressRepo;
import com.skylivings.webapp.repo.ManagerRepo;
import com.skylivings.webapp.repo.RoleRepo;
import com.skylivings.webapp.repo.TenantRepo;
import com.skylivings.webapp.repo.UserRepo;


@Service
public class ManagerService {
	
	@Autowired
	ManagerRepo managerRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AddressRepo addressRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	TenantRepo tenantRepo;
	
	public List<PropertyManager> getManagerList(){
		return managerRepo.findAll();
	}
	
	public ManagerDTO addNewManager(ManagerDTO managerDTO) {
		PropertyManager manager = new PropertyManager();
		manager.setFirstName(managerDTO.getFirstName());
		manager.setLastName(managerDTO.getLastName());
		manager.setEmail(managerDTO.getEmail());
		manager.setContact(managerDTO.getContact());
		manager.setAlternativeContact(managerDTO.getAlternativeContact());
		manager.setGender(managerDTO.getGender());
	
		
		Address address = new Address();
		address.setFlatNumber(managerDTO.getFirstName());
		address.setStreetName(managerDTO.getStreetName());
		address.setCity(managerDTO.getCity());
		address.setState(managerDTO.getState());
		address.setPincode(managerDTO.getZip());
		address.setCity(managerDTO.getCountry());
		manager.setAddress(address);
		
		Role role = roleRepo.getById(1);
		
		User user = new User();
		user.setUsername(managerDTO.getEmail());
		user.setUserPassword(managerDTO.getFirstName()+"#"+managerDTO.getContact().substring(0, 6));
		user.setRole(role);
		manager.setUser(user);
		
		managerRepo.save(manager);
		
		return managerDTO; 
	}
	
	public Tenant checkoutTenant(TenantCheckoutDTO checkoutDTO) {
		System.out.println(checkoutDTO.getPropertyId());
		System.out.println(checkoutDTO.getTenantId());
		Tenant tenant = tenantRepo.getById(checkoutDTO.getTenantId());
		tenant.setTenantStatus(TenantStatus.INACTIVE);
		tenant.setCheckOutDate(checkoutDTO.getCheckOutDate());
		tenant.setRemarks(checkoutDTO.getRemarks());
		tenantRepo.save(tenant);
		return tenant;
	}
	
	
}
