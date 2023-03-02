package com.skylivings.webapp.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.skylivings.webapp.model.enums.PaymentMethod;
import com.skylivings.webapp.model.enums.PaymentStatus;

import lombok.Data;

@Data
@Entity
public class Payment {
	@Id
	private long paymentId;
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
//	private PropertyManager paymentReciever;
	private Calendar paymentDate;
	private String transactionId;
	
	
}
