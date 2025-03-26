package com.valtech.training.springwebassignment.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Table(name="customer1")
public class Customer {

	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custseq")
	@SequenceGenerator(name = "custseq",sequenceName = "cust_seq",allocationSize = 1)
	private long id;
	private String name;
	private int age;
	private String address;
	private String permanantAddress;
	
	@OneToMany(targetEntity = Order.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
	private List<Order> orders;

	public void addOrder(Order order) {
		if(orders ==null) orders = new ArrayList<Order>();
		orders.add(order);
		order.setCustomer(this);
	}
	
	public Customer() {}

	public Customer(String name, int age, String address, String permanantAddress) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.permanantAddress = permanantAddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPermanantAddress() {
		return permanantAddress;
	}

	public void setPermanantAddress(String permanantAddress) {
		this.permanantAddress = permanantAddress;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
}
