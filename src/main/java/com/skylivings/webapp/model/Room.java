package com.skylivings.webapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.skylivings.webapp.model.enums.PropertyType;
import com.skylivings.webapp.model.enums.RoomStatus;

import lombok.Data;

@Entity
@Data
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;
	private String roomNumber;
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Tenant> tenants;
	private String desctiption;
	private double rent;
	private int numberOfBedrooms;
	private int numberOrBathrooms;
	private double deposit;
	private int capacity;
	private PropertyType roomType;
	@ElementCollection
	private List<String> amenities;
	@Enumerated(EnumType.STRING)
	private RoomStatus roomStatus;
	@OneToOne
	private Payment payment;
	
}
