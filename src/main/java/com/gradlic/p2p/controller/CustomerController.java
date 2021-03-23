package com.gradlic.p2p.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradlic.p2p.model.Customer;
import com.gradlic.p2p.repository.CustomerRepository;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("api/v1/customers")
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
	}
	
	@GetMapping("api/v1/customers/{id}")
	public Customer getCustomerById(@PathVariable String id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (!optional.isPresent()) {
			throw new RuntimeException("No customer found with given id: "+id);
		}
		
		return optional.get();
	}
	
	@PostMapping("api/v1/customers")
	public void saveCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}
	
	@PutMapping("api/v1/customers/{id}")
	public void updateCustomer(@RequestBody Customer customer, @PathVariable String id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (!optional.isPresent()) {
			throw new RuntimeException("No customer found with given id : "+id);
		}
		
		customer.setId(optional.get().getId());
		
		customerRepository.save(customer);
	}
	
	

}
