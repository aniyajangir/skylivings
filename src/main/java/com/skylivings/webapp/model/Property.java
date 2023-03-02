package com.skylivings.webapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.skylivings.webapp.model.enums.PropertyStatus;
import com.skylivings.webapp.model.enums.PropertyType;

import lombok.Data;

@Data
@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyId;
	private String propertyCode;
	private String propertyName;
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	@Enumerated(EnumType.STRING)
	private PropertyStatus propertyStatus;
	private Date onBoardingDate;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Address address;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "managerId")
	private PropertyManager manager;
	@OneToMany
	private List<Room> rooms;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ownerId")
	private PropertyOwner owner;
}
