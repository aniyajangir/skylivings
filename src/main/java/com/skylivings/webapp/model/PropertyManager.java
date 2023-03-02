package com.skylivings.webapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.skylivings.webapp.model.enums.Gender;

import lombok.Data;

@Data
@Entity
public class PropertyManager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int managerId;
	private String firstName;
	private String lastName;
	private String contact;
	private String alternativeContact;
	private String email;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Property> properties;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "addressId")
	private Address address;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userId")
	private User user;
}
