package com.valtech.training.assignment.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.*;

@Entity
public class Customer {


	@Id@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "cust_seq")
	@SequenceGenerator(name = "cust_seq",sequenceName = "cust_seq",allocationSize = 1)
	private long id;
	
	
	private String name;
	
	private int age;
	
	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name = "streetName", column = @Column(name = "current_street")),
	    @AttributeOverride(name = "cityName", column = @Column(name = "current_city")),
	    @AttributeOverride(name = "pinCode", column = @Column(name = "current_pinCode"))
	})
	private Address currentAddress;

	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name = "streetName", column = @Column(name = "permanent_street")),
	    @AttributeOverride(name = "cityName", column = @Column(name = "permanent_city")),
	    @AttributeOverride(name = "pinCode", column = @Column(name = "permanent_pinCode"))
	})
	private Address permanantAdress;
	
	@OneToMany(targetEntity = Orders.class, mappedBy="customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Orders> orders;
	

	public Customer() {}

	public Customer(long id, String name, int age, Address currentAddress,Address permanantAdress) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.currentAddress = currentAddress;
		this.permanantAdress=permanantAdress;

	}

	public enum CustomerStatus{
		ENABLED,DISABLED
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

	public Address getCurrentAdress() {
		return currentAddress;
	}

	public void setCurrentAdress(Address currentAdress) {
		this.currentAddress = currentAdress;
	}


	public List<Orders> getOrders() {
		if(orders==null) orders=new ArrayList<>();
		return orders;
	}

	public void AddOrders(Orders o) {
		List<Orders>orders=getOrders();
		orders.add(o);	
		
	}
	
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public Address getPermanantAdress() {
		return permanantAdress;
	}

	public void setPermanantAdress(Address permanantAdress) {
		this.permanantAdress = permanantAdress;
	}
	
	
}
