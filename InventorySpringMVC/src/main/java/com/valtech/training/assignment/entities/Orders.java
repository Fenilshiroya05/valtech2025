package com.valtech.training.assignment.entities;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Orders {

	@Id@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "ord_seq")
	@SequenceGenerator(name = "ord_seq",sequenceName = "ord_seq",allocationSize = 1)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@OneToMany(mappedBy = "orders",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<LineItem>lineItems;
	
	@ManyToOne(targetEntity = Customer.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id",referencedColumnName = "id")
	private Customer customer;
	
	public enum OrderStatus{
		
		PENDING,PROCESSING,SHIPPED,DELIVERED
	}
	
	public Orders() {}

	public Orders(long id, List<LineItem> lineItems, Customer customer, OrderStatus orderStatus) {
		super();
		this.id = id;
		this.lineItems = lineItems;
		this.customer = customer;
		this.orderStatus = orderStatus;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	
	
	
	
}
