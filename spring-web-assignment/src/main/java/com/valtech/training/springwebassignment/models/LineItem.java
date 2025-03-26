package com.valtech.training.springwebassignment.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class LineItem {

	private long id;
	private int qty;
	
	@ManyToOne(targetEntity = Order.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId",referencedColumnName = "id")
	private Order order;
	
	@ManyToOne(targetEntity = Item.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="itemId",referencedColumnName = "id")
	private Item item;

	public LineItem() {}

	public LineItem(long id, int qty) {
		this.id = id;
		this.qty = qty;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
