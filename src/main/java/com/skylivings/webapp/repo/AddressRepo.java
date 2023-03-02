package com.skylivings.webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skylivings.webapp.model.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
