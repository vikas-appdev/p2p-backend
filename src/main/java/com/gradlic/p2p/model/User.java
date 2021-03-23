package com.gradlic.p2p.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gradlic.p2p.utils.Address;

@Entity
public class User {
	
	@Id
	private String id;

	private String firstName;
	private String lastName;
	
	private String password;
	
	private String email;
	
	private Long mobileNumber;
	private String whatsappNumber;
	
	private String profilePic;
	

	private String aadharcard;
	
	private String pancard;
	
	private String gurdianName;
	private Long gurdianContactNumber;
	
	private long bankAccountNumber;
	private String bankAccountHolderName;
	private String Ifsccode;
	
	private LocalDate dateOfBirth;
	
	private Address address;
	
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<SubscriptionDelivery> subscriptionDeliveries;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getWhatsappNumber() {
		return whatsappNumber;
	}

	public void setWhatsappNumber(String whatsappNumber) {
		this.whatsappNumber = whatsappNumber;
	}
	
	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getAadharcard() {
		return aadharcard;
	}

	public void setAadharcard(String aadharcard) {
		this.aadharcard = aadharcard;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getGurdianName() {
		return gurdianName;
	}

	public void setGurdianName(String gurdianName) {
		this.gurdianName = gurdianName;
	}

	public Long getGurdianContactNumber() {
		return gurdianContactNumber;
	}

	public void setGurdianContactNumber(Long gurdianContactNumber) {
		this.gurdianContactNumber = gurdianContactNumber;
	}

	public long getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(long bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankAccountHolderName() {
		return bankAccountHolderName;
	}

	public void setBankAccountHolderName(String bankAccountHolderName) {
		this.bankAccountHolderName = bankAccountHolderName;
	}

	public String getIfsccode() {
		return Ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		Ifsccode = ifsccode;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<SubscriptionDelivery> getSubscriptionDeliveries() {
		return subscriptionDeliveries;
	}

	public void setSubscriptionDeliveries(List<SubscriptionDelivery> subscriptionDeliveries) {
		this.subscriptionDeliveries = subscriptionDeliveries;
	}
	
	
	

}
