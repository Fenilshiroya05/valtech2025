package com.valtech.training.assignment.entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Item {

	@Id@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "item_seq")
	@SequenceGenerator(name = "item_seq",sequenceName = "item_seq",allocationSize = 1)
	private long id;
	private String name;
	private int maxQuantity;
	private int currentQuantity;
	private int reOrderValue;
	
	
	@OneToMany(mappedBy="item",fetch = FetchType.EAGER)
	private List<LineItem>lineItems;
	
	public Item() {}

	public Item(long id,String name, int maxQuantity, int currentQuantity, int reOrderValue) {
		super();
		this.id = id;
		this.name=name;
		this.maxQuantity = maxQuantity;
		this.currentQuantity = currentQuantity;
		this.reOrderValue = reOrderValue;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	public int getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
	public int getReOrderValue() {
		return reOrderValue;
	}
	public void setReOrderValue(int reOrderValue) {
		this.reOrderValue = reOrderValue;
	}
	
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", maxQuantity=" + maxQuantity + ", currentQuantity=" + currentQuantity
				+ ", reOrderValue=" + reOrderValue + "]";
	}
	
	
	public boolean checkItemAvailability(int orderQuantity) {
		
		if( orderQuantity> getMaxQuantity()) {
			return false;
		}
		else if(orderQuantity>getCurrentQuantity()) {
			return false;
		}
		
		else {
			return true;
		}
		
	}
	
	public boolean checkReOrderStatus(int orderQuantity) {
		if(getCurrentQuantity()-orderQuantity<=getReOrderValue()) {
			return true ;
		}
		else {
			return false;
		}
	}
}
