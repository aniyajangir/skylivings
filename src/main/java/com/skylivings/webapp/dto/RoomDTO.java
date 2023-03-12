package com.skylivings.webapp.dto;

import java.util.List;

import com.skylivings.webapp.model.Tenant;
import com.skylivings.webapp.model.enums.PropertyType;

import lombok.Data;

@Data
public class RoomDTO {
	private int roomId;
	private PropertyType roomType;
	private int roomSize;
	private int deposit;
	private int bedrooms;
	private int bathrooms;
	private String roomNumber;
	private List<Tenant> tenants;
	private int rent;
	private String roomStatus;
	private String description;
	private int capacity;
	private int quantity;
}
