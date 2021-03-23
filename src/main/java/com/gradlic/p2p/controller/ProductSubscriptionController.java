package com.gradlic.p2p.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradlic.p2p.model.Customer;
import com.gradlic.p2p.model.ProductSubscription;
import com.gradlic.p2p.repository.CustomerRepository;
import com.gradlic.p2p.repository.ProductSubscriptionRepository;

@RestController
@CrossOrigin(origins = "*")
public class ProductSubscriptionController {
	
	@Autowired
	private ProductSubscriptionRepository productSubscriptionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping("api/v1/{customer}/subscriptions")
	public void save(@PathVariable String customer, @RequestBody ProductSubscription productSubscription) {
		Optional<Customer> optional = customerRepository.findById(customer);
		
		if (!optional.isPresent()) {
			throw new RuntimeException("No customer found with given id: "+customer);
		}
		
		productSubscription.setCustomer(optional.get());
		
		productSubscriptionRepository.save(productSubscription);
		
	}
	
	@GetMapping("api/v1/subscriptions")
	public List<ProductSubscription> getAll() {
		return productSubscriptionRepository.findAll();
	}
	
	

}
