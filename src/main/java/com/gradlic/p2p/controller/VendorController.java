package com.gradlic.p2p.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gradlic.p2p.model.Category;
import com.gradlic.p2p.model.Item;
import com.gradlic.p2p.model.Vendor;
import com.gradlic.p2p.repository.CategoryRepository;
import com.gradlic.p2p.repository.ItemRepository;
import com.gradlic.p2p.repository.VendorRepository;

@RestController
@CrossOrigin(origins = "*")
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping("api/v1/vendors")
	public List<Vendor> getAllVendors() {
		return vendorRepository.findAll(Sort.by(Sort.Direction.ASC, "vendorName"));
	}
	
	@PostMapping("api/v1/vendors")
	public void saveVendor(@RequestBody Vendor vendor) {
		vendorRepository.save(vendor);
	}
	
	
	
	

}
