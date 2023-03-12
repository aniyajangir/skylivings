package com.skylivings.webapp.dto;

import java.util.Date;
import java.util.List;

import com.skylivings.webapp.model.PropertyManager;
import com.skylivings.webapp.model.Room;
import com.skylivings.webapp.model.enums.PropertyStatus;
import com.skylivings.webapp.model.enums.PropertyType;

import lombok.Data;

@Data
public class PropertyDTO {
	 private String propertyCode;
	 private PropertyType propertyType;
	 private String propertyName;
	 private String propertyStatus;
	 private String buildingName;
	 private String streetName;
	 private String city;
	 private String state;
	 private String country;
	 private long zip;
	 private Date onBoardingDate;
	 private String ownerId;
	 private String firstName;
	 private String lastName;
	 private String contact;
	 private String alternativeContact;
	 private String email;
	 private String gender;
	 private int managerId;
	 private List<RoomDTO> rooms;
}
