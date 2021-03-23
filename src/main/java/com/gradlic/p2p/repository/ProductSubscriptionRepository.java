package com.gradlic.p2p.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradlic.p2p.model.ProductSubscription;

public interface ProductSubscriptionRepository extends JpaRepository<ProductSubscription, Integer> {
	
}
