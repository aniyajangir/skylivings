package com.skylivings.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skylivings.webapp.model.Payment;
import com.skylivings.webapp.repo.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
	PaymentRepo paymentRepo;

	public Payment newPayment(Payment payment) {
		return paymentRepo.save(payment);
	}

}
