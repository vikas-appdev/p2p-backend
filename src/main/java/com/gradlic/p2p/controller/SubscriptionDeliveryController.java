package com.gradlic.p2p.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradlic.p2p.model.SubscriptionDelivery;
import com.gradlic.p2p.repository.SubscriptionDeliveryRepository;

@RestController
public class SubscriptionDeliveryController {
	
	@Autowired
	private SubscriptionDeliveryRepository deliveryRepository;
	
	public void save(@RequestBody SubscriptionDelivery subscriptionDelivery) {
		deliveryRepository.save(subscriptionDelivery);
	}

}
