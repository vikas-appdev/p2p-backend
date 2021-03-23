package com.gradlic.p2p.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradlic.p2p.model.PurchaseBill;
import com.gradlic.p2p.model.PurchaseRecord;
import com.gradlic.p2p.repository.PurchaseBillRepository;
import com.gradlic.p2p.repository.PurchaseRecordRepository;

@RestController
public class PurchaseRecordController {
	
	@Autowired
	private PurchaseRecordRepository purchaseRecordRepository;
	
	@Autowired
	private PurchaseBillRepository purchaseBillRepository;
	
	@PostMapping("api/v1/{billid}/purchaserecord")
	public void savePurchaseRecord(@PathVariable int billid, @RequestBody PurchaseRecord purchaseRecord) {
		Optional<PurchaseBill> optional = purchaseBillRepository.findById(billid);
		if (!optional.isPresent()) {
			throw new RuntimeException("No bill found with bill id: "+billid);
		}
		
		purchaseRecord.setPurchaseBill(optional.get());
		
		purchaseRecordRepository.save(purchaseRecord);
		
	}
	
	@GetMapping("api/v1/{billid}/purchaserecord")
	public List<PurchaseRecord> purchaseRecords(@PathVariable int billid){
		return purchaseRecordRepository.findByPurchaseBillId(billid);
	}
	
	
	
	

}
