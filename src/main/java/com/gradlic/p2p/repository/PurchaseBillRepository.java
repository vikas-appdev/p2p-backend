package com.gradlic.p2p.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradlic.p2p.model.Category;
import com.gradlic.p2p.model.PurchaseBill;
import com.gradlic.p2p.model.Vendor;

public interface PurchaseBillRepository extends JpaRepository<PurchaseBill, Integer> {

}
