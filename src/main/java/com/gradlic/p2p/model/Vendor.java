package com.gradlic.p2p.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.gradlic.p2p.utils.Address;

@Entity
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String vendorName;
	
	@OneToMany(mappedBy = "vendor")
	private List<PurchaseBill> purchaseBill;
	
	private String contactPerson;
	
	private long phone;
	
	private String email;
	
	@Embedded
	private Address address;
	
	private double openingAccountBalance;
	
	private LocalDate openingBalanceDate;
	
	private String remarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getOpeningAccountBalance() {
		return openingAccountBalance;
	}

	public void setOpeningAccountBalance(double openingAccountBalance) {
		this.openingAccountBalance = openingAccountBalance;
	}

	public LocalDate getOpeningBalanceDate() {
		return openingBalanceDate;
	}

	public void setOpeningBalanceDate(LocalDate openingBalanceDate) {
		this.openingBalanceDate = openingBalanceDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<PurchaseBill> getPurchaseBill() {
		return purchaseBill;
	}

	public void setPurchaseBill(List<PurchaseBill> purchaseBill) {
		this.purchaseBill = purchaseBill;
	}
	
	

}
