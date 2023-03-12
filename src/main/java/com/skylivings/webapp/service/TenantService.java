package com.skylivings.webapp.service;

import java.util.List;

import java.util.stream.Collectors;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylivings.webapp.dto.TenantCheckoutDTO;
import com.skylivings.webapp.dto.TenantDTO;
import com.skylivings.webapp.model.Address;
import com.skylivings.webapp.model.Property;
import com.skylivings.webapp.model.PropertyManager;
import com.skylivings.webapp.model.Role;
import com.skylivings.webapp.model.Room;
import com.skylivings.webapp.model.Tenant;
import com.skylivings.webapp.model.TenantGovtDetails;
import com.skylivings.webapp.model.User;
import com.skylivings.webapp.model.enums.TenantStatus;
import com.skylivings.webapp.repo.AddressRepo;
import com.skylivings.webapp.repo.ManagerRepo;
import com.skylivings.webapp.repo.PropertyRepo;
import com.skylivings.webapp.repo.RoleRepo;
import com.skylivings.webapp.repo.RoomRepo;
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
	
	@Autowired
	RoomRepo roomRepo;

	public Tenant addNewTenant(Tenant tenant) {
		return tenantRepo.save(tenant);
	}

	public List<Tenant> findAll() {
		return tenantRepo.findAll();
	}

	public List<Tenant> getTenantPersonalDetails() {
		return tenantRepo.findAll();
//				.stream().map(this::convertTenantToDTO)
//				.collect(Collectors.toList());
	}

	public List<Tenant> getActiveTenantList(){
		return tenantRepo.getActiveTenantList();
	}
//	public TenantCheckoutDTO checkedOutTenantList(Tenant tenant) {
//		TenantCheckoutDTO checkoutDTO = new TenantCheckoutDTO();
//		checkoutDTO.setTenantId(tenant.getTenantId());
//		checkoutDTO.setCheckOutDate(tenant.getCheckOutDate());
//		Property property = propertyRepo.getById()
//		Room room = roomRepo.getById();
//		checkoutDTO.set
//	}
//	public TenantDTO convertTenantToDTO(Tenant tenant) {
//		TenantDTO tenantDTO = new TenantDTO();
//		tenantDTO.setId(tenant.getId());
//		tenantDTO.setFirstName(tenant.getFirstName());
//		tenantDTO.setLastName(tenant.getLastName());
//		tenantDTO.setContact(tenant.getContact());
//		tenantDTO.setEmail(tenant.getEmail());
//		tenantDTO.setGender(tenant.getGender());
//		tenantDTO.setHeadRoomMate(tenant.getHeadRoomMate());
//		tenantDTO.setAlternativeContact(tenant.getAlternativeContact());
//		return tenantDTO;
//	}

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
			tenant.setCheckInDate(tenantDTO.getCheckInDate());
			tenant.setHeadRoomMate(tenantDTO.getHeadRoomMate());

			// New Tenant address
			Address address = new Address();
			address.setFlatNumber(tenantDTO.getFlatNumber());
			address.setStreetName(tenantDTO.getStreetName());
			address.setCountry(tenantDTO.getCountry());
			address.setCity(tenantDTO.getCity());
			address.setPincode(tenantDTO.getZip());
			address.setState(tenantDTO.getState());

			//Tenant Nationality Details
			TenantGovtDetails govtDetails = new TenantGovtDetails();
			govtDetails.setAadharNumber(tenantDTO.getAadharNumber());
			govtDetails.setPanNumber(tenantDTO.getPanNumber());
			govtDetails.setNationality(tenantDTO.getNationality());
			govtDetails.setPassportNumber(tenantDTO.getPassportNumber());
			govtDetails.setPassportExpiryDate(tenantDTO.getPassportExpiryDate());
			govtDetails.setVisaExpiryDate(tenantDTO.getVisaExpiryDate());
			govtDetails.setVisaNumber(tenantDTO.getVisaNumber());
			govtDetails.setVisaType(tenantDTO.getVisaType());
			
			//Assigning details to tenant
			tenant.setGovtDetails(govtDetails);
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
			
			Property property = propertyRepo.getById(tenantDTO.getPropertyId());
			tenant.setProperty(property);
			
			List<Room> rooms = property.getRooms();
			for(int i = 0; i<rooms.size(); i++) {
				if(rooms.get(i).getRoomId() == tenantDTO.getRoomId()) {
					tenant.setRoom(rooms.get(i));
				}
			}
			
//			int roomId = tenantDTO.getRoomId();
//			List<Room> rooms = tenant.getProperty().getRooms();
//
//			for(int i = 0; i<rooms.size(); i++) {
//				if(rooms.get(i).getRoomId() == roomId) {
//					rooms.get(i).getTenants().add(tenant);
//				}
//			}
			
			tenantRepo.save(tenant);
			return tenantDTO;

		} catch (Exception e) {
			System.out.println("Try again" + e);
			return tenantDTO;
		}

	}
	
	public List<Tenant> getRoomMatesList(int tenantId){
		Tenant tenant = tenantRepo.getById(tenantId);
		int roomId = tenant.getRoom().getRoomId();
		List<Tenant> roomTenants = tenantRepo.getTenantByRoom(roomId);
		System.out.println(roomTenants);
		return roomTenants;
	}
	

	public TenantDTO getTenantById(int tenantId) {
		Tenant tenant = tenantRepo.getById(tenantId);
		TenantDTO tenantDTO = new TenantDTO();
		tenantDTO.setTeanantId(tenant.getTenantId());
		tenantDTO.setFirstName(tenant.getFirstName());
		tenantDTO.setLastName(tenant.getLastName());
		tenantDTO.setContact(tenant.getContact());
		tenantDTO.setEmail(tenant.getEmail());
		tenantDTO.setGender(tenant.getGender());
		tenantDTO.setHeadRoomMate(tenant.getHeadRoomMate());
		tenantDTO.setAlternativeContact(tenant.getAlternativeContact());
		tenantDTO.setPropertyName(tenant.getProperty().getPropertyName());
		tenantDTO.setRoomNumber(tenant.getRoom().getRoomNumber());
		tenantDTO.setDeposit(tenant.getRoom().getDeposit());
		tenantDTO.setRoom(tenant.getRoom());
		tenantDTO.setAddress(tenant.getAddress());
		tenantDTO.setCheckInDate(tenant.getCheckInDate());
		tenantDTO.setCheckOutDate(tenant.getCheckOutDate());
		tenantDTO.setTenantStatus(tenant.getTenantStatus());
		tenantDTO.setAadharNumber(tenant.getGovtDetails().getAadharNumber());
		tenantDTO.setPanNumber(tenant.getGovtDetails().getPanNumber());
		return tenantDTO;
	}

}
