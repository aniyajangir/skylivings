package com.skylivings.webapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.skylivings.webapp.model.enums.RoomStatus;

import lombok.Data;

@Entity
@Data
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roomId;
	private String roomNumber;
	@OneToMany
	private List<Tenant> tenants;
	private String desctiption;
	private double rent;
	@Enumerated(EnumType.STRING)
	private RoomStatus roomStatus;
	@OneToOne
	private Payment payment;
}
