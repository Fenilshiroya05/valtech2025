package com.valtech.training.springwebassignment.models;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

public class Order {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderseq")
	@SequenceGenerator(name = "orderseq",sequenceName = "order_seq",allocationSize = 1)
	private long id;
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	public enum OrderStatus{
		DELIVERED,CANCELED, PENDING, DISPACHED;
	}
	
	@OneToMany(targetEntity = LineItem.class,mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<LineItem> lineItems;
	
	public void addLineItem(LineItem lm) {
		if(lineItems==null) lineItems = new ArrayList<LineItem>();
		lineItems.add(lm);
		lm.setOrder(this);
	}
	
	
	@ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="customerId",referencedColumnName = "id")
	private Customer customer;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
