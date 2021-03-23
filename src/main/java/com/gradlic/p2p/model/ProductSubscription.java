package com.gradlic.p2p.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProductSubscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Customer customer;
	
	private String subscribeFor;
	
	private boolean isActive;
	
	private LocalDate subscriptionDate;
	
	private double quantity;
	
	private double rate;
	
	private String deliveryTime;
	
	@OneToMany(mappedBy = "productSubscription")
	@JsonIgnore
	private List<SubscriptionDelivery> subscriptionDeliveries;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCustomerId() {
		return customer.getId();
	}

	public String getCustomer() {
		return customer.getFirstName()+" "+customer.getLastName();
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getSubscribeFor() {
		return subscribeFor;
	}

	public void setSubscribeFor(String subscribeFor) {
		this.subscribeFor = subscribeFor;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDate getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(LocalDate subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	
	
	
	

}
