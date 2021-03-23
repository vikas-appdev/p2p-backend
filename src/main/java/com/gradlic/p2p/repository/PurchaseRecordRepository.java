package com.gradlic.p2p.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradlic.p2p.model.PurchaseRecord;


public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Integer> {
	
	
	List<PurchaseRecord> findByPurchaseBillId(int purchaseBillId);

}
