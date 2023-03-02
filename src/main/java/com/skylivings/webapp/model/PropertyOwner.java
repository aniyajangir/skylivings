package com.skylivings.webapp.model;




import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.skylivings.webapp.model.enums.Gender;

import lombok.Data;

@Entity
@Data
public class PropertyOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;
	private String firstName;
	private String lastName;
	private String contact;
	private String alternativeContact;
	private String email;
	private String gender;
//	@OneToMany
//	private List<Property> properties;
//	@OneToOne
//	private User user;
}
