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
public class Customer {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String locale;
	private boolean isEmailVerified;
	
	private Long whatsappNumber;
	private Long callNumber;
	private LocalDate dateOfBirth;
	
	private String website;
	private String profilePic;
	private String password;
	private int gender;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "customer")
	private List<SaleBill> saleBills;
	
	@OneToMany(mappedBy = "customer")
	private List<ProductSubscription> productSubscriptions;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public Long getWhatsappNumber() {
		return whatsappNumber;
	}

	public void setWhatsappNumber(Long whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}

	public Long getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(Long callNumber) {
		this.callNumber = callNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public List<ProductSubscription> getProductSubscriptions() {
		return productSubscriptions;
	}

	public void setProductSubscriptions(List<ProductSubscription> productSubscriptions) {
		this.productSubscriptions = productSubscriptions;
	}

	public List<SaleBill> getSaleBills() {
		return saleBills;
	}

	public void setSaleBills(List<SaleBill> saleBills) {
		this.saleBills = saleBills;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}


	

}
