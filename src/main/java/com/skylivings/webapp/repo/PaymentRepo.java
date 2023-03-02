package com.skylivings.webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skylivings.webapp.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
