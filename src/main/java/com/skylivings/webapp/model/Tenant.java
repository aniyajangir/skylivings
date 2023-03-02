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
	private long id;
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
	private boolean headRoomMate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	@ManyToOne
	private Property property;
	@ManyToOne
	private Room room;
	public boolean getHeadRoomMate() {
		return this.headRoomMate;
	}
}
