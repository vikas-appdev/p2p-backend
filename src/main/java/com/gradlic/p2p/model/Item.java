package com.gradlic.p2p.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String itemName;
	private String itemDescription;
	private String unitType;
	private String itemImage;
	
	@ManyToOne
	@JsonIgnore
	private Category category;
	
	@OneToMany(mappedBy = "item")
	@JsonIgnore
	private List<PurchaseRecord> purchaseRecords;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<PurchaseRecord> getPurchaseRecords() {
		return purchaseRecords;
	}

	public void setPurchaseRecords(List<PurchaseRecord> purchaseRecords) {
		this.purchaseRecords = purchaseRecords;
	}
	
	
	
}
