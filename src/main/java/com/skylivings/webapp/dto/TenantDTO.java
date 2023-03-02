package com.skylivings.webapp.dto;

import com.skylivings.webapp.model.Property;
import com.skylivings.webapp.model.enums.Gender;

import lombok.Data;

@Data
public class TenantDTO {
	private long id;
	private String firstName;
	private String lastName;
	private String contact;
	private String alternativeContact;
	private String email;
	private Gender gender;
	private boolean headRoomMate;
	private String username;
	private String password;
	private String confirmPassword;
	private String flatNumber;
	private String streetName;
	private String state;
	private String country;
	private long zip;
	private String city;
	private String roomNumber;
	private Property property;

}
