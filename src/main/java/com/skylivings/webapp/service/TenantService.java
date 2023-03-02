package com.skylivings.webapp.service;

import java.util.List;

import java.util.stream.Collectors;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylivings.webapp.dto.TenantDTO;
import com.skylivings.webapp.model.Address;
import com.skylivings.webapp.model.Property;
import com.skylivings.webapp.model.PropertyManager;
import com.skylivings.webapp.model.Role;
import com.skylivings.webapp.model.Room;
import com.skylivings.webapp.model.Tenant;
import com.skylivings.webapp.model.User;
import com.skylivings.webapp.model.enums.TenantStatus;
import com.skylivings.webapp.repo.AddressRepo;
import com.skylivings.webapp.repo.ManagerRepo;
import com.skylivings.webapp.repo.PropertyRepo;
import com.skylivings.webapp.repo.RoleRepo;
import com.skylivings.webapp.repo.TenantRepo;
import com.skylivings.webapp.repo.UserRepo;

@Service
public class TenantService {
	@Autowired
	TenantRepo tenantRepo;

	@Autowired
	RoleRepo roleRepo;

	@Autowired
	AddressRepo addressRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	ManagerRepo managerRepo;
	
	@Autowired
	PropertyRepo propertyRepo;

	public Tenant addNewTenant(Tenant tenant) {
		return tenantRepo.save(tenant);
	}

	public List<Tenant> findAll() {
		return tenantRepo.findAll();
	}

	public List<TenantDTO> getTenantPersonalDetails() {
		return ((List<Tenant>) tenantRepo.findAll()).stream().map(this::convertTenantToDTO)
				.collect(Collectors.toList());
	}

	public TenantDTO convertTenantToDTO(Tenant tenant) {
		TenantDTO tenantDTO = new TenantDTO();
		tenantDTO.setId(tenant.getId());
		tenantDTO.setFirstName(tenant.getFirstName());
		tenantDTO.setLastName(tenant.getLastName());
		tenantDTO.setContact(tenant.getContact());
		tenantDTO.setEmail(tenant.getEmail());
		tenantDTO.setGender(tenant.getGender());
		tenantDTO.setHeadRoomMate(tenant.getHeadRoomMate());
		tenantDTO.setAlternativeContact(tenant.getAlternativeContact());
		return tenantDTO;
	}

	public TenantDTO addTenant(TenantDTO tenantDTO) {
		try {
			// Creating new tenant
			Tenant tenant = new Tenant();
			tenant.setFirstName(tenantDTO.getFirstName());
			tenant.setLastName(tenantDTO.getLastName());
			tenant.setContact(tenantDTO.getContact());
			tenant.setAlternativeContact(tenantDTO.getAlternativeContact());
			tenant.setGender(tenantDTO.getGender());
			tenant.setEmail(tenantDTO.getEmail());
			tenant.setTenantStatus(TenantStatus.ACTIVE);

			// New Tenant address
			Address address = new Address();
			address.setFlatNumber(tenantDTO.getFlatNumber());
			address.setStreetName(tenantDTO.getStreetName());
			address.setCountry(tenantDTO.getCountry());
			address.setCity(tenantDTO.getCity());
			address.setPincode(tenantDTO.getZip());
			address.setState(tenantDTO.getState());

			// Setting address for new tenant
			tenant.setAddress(address);

			// New User tennant
			User user = new User();
			
			// Username is same as email address
			user.setUsername(tenantDTO.getEmail());
			
			// Default password is FirstName+@+Contact(0-4)
			user.setUserPassword(tenantDTO.getFirstName() + "@" + tenant.getContact().substring(0, 4));
			
			// Default role for tenant is User
			Role role = roleRepo.getById(2);
			user.setRole(role);
			
			tenant.setUser(user);

			int id = tenantDTO.getProperty().getPropertyId();
			Property property = propertyRepo.getById(id);
			tenant.setProperty(property);
			
			tenantRepo.save(tenant);
			return tenantDTO;

		} catch (Exception e) {
			System.out.println("Try again" + e);
			return tenantDTO;
		}

	}

}
