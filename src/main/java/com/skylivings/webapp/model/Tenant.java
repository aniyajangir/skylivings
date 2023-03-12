package com.skylivings.webapp.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.skylivings.webapp.model.enums.Gender;
import com.skylivings.webapp.model.enums.TenantStatus;

import lombok.Data;

@Data
@Entity
public class Tenant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tenantId;
	private String firstName;
	private String lastName;
	private String contact;
	private String alternativeContact;
	private String email;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated(EnumType.STRING)
	private TenantStatus tenantStatus;
	private Date checkInDate;
	private Date checkOutDate;
	private String remarks;
	private String headRoomMate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	@ManyToOne
	@JoinColumn(name = "propertyId")
	private Property property;
	@ManyToOne
	@JoinColumn(name = "roomId")
	private Room room;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tenantGovtDetails")
	private TenantGovtDetails govtDetails;

}
