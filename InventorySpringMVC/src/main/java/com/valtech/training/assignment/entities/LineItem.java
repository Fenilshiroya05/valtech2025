package com.valtech.training.assignment.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LineItem {


	@Id@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "line_seq")
	@SequenceGenerator(name = "line_seq",sequenceName = "line_seq",allocationSize = 1)
	private long id;
	private int orderQty;
	
	@ManyToOne(targetEntity = Item.class,fetch=FetchType.EAGER)
	private Item item;
	
	@ManyToOne(targetEntity = Orders.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Orders orders;
	
	public LineItem( Item item, Orders orders, int orderQuantity) {
		super();
		this.item = item;
		this.orders = orders;
		this.orderQty = orderQuantity;
	}

	public LineItem() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Orders getOrder() {
		return orders;
	}

	public void setOrder(Orders orders) {
		this.orders = orders;
	}

	public int getOrderQuantity() {
		return orderQty;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQty = orderQuantity;
	}
	
}
