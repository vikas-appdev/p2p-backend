package com.gradlic.p2p.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradlic.p2p.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	

}
