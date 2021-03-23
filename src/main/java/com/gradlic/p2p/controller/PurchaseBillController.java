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
import com.gradlic.p2p.model.Vendor;
import com.gradlic.p2p.repository.PurchaseBillRepository;
import com.gradlic.p2p.repository.VendorRepository;

import javassist.NotFoundException;

@RestController
public class PurchaseBillController {
	
	@Autowired
	private PurchaseBillRepository purchaseBillRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@PostMapping("api/v1/{vendorid}/purchasebills")
	public void savePurchaseBill(@PathVariable int vendorid, @RequestBody PurchaseBill purchaseBill) {
		Optional<Vendor> optional = vendorRepository.findById(vendorid);
		if(!optional.isPresent()) {
			throw new RuntimeException("No vendor found with given id: "+vendorid);
		}
		
		purchaseBill.setVendor(optional.get());
		
		
		purchaseBillRepository.save(purchaseBill);
	}
	
	@GetMapping("api/v1/purchasebills")
	public List<PurchaseBill> getAllPurchaseBill() {
		return purchaseBillRepository.findAll();
	}
	
	

}
