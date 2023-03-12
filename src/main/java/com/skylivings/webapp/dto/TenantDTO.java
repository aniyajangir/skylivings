package com.skylivings.webapp.dto;

import java.sql.Date;

import com.skylivings.webapp.model.Address;
import com.skylivings.webapp.model.Property;
import com.skylivings.webapp.model.Room;
import com.skylivings.webapp.model.enums.Gender;
import com.skylivings.webapp.model.enums.TenantStatus;

import lombok.Data;

@Data
public class TenantDTO {
	private int teanantId;
	private String firstName;
	private Date checkInDate;
	private Date checkOutDate;
	private String lastName;
	private String contact;
	private String alternativeContact;
	private String email;
	private Gender gender;
	private String headRoomMate;
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
	private Room room;
	private int propertyId;
	private String propertyName;
	private int roomId;
	private double rent;
	private double deposit;
	private Address address;
	private TenantStatus tenantStatus;
	private int govtId;
	private String aadharNumber;
	private String panNumber;
	private String passportNumber;
	private Date passportExpiryDate;
	private String visaNumber;
	private Date visaExpiryDate;
	private String visaType;
	private String nationality;
}
