package com.valtech.training.assignment.vos;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.valtech.training.assignment.entities.Address;
import com.valtech.training.assignment.entities.Customer;



public record CustomerVO(long id,String name,int age,String currentCity,int currentPinCode,
		String currentStreet,String permanantCity,int permanantPinCode,String permanantStreet,Set<Long>OrderIds ){
	
	public static  CustomerVO from(Customer c) {
		Set<Long> orderIds=c.getOrders().stream().map(w->w.getId()).collect(Collectors.toSet());
		return new CustomerVO(c.getId(),c.getName(),c.getAge(),c.getCurrentAdress().getCity(),
				c.getCurrentAdress().getPinCode(),c.getCurrentAdress().getStreet(),c.getPermanantAdress().getCity(),
				c.getPermanantAdress().getPinCode(),c.getPermanantAdress().getStreet(),orderIds);	
	}
	
	public Customer to() {
		Address permanantAdress=new Address(currentCity,currentPinCode,currentStreet);
		Address currentAdress=new Address(permanantCity,permanantPinCode,permanantStreet);
		
		return new Customer(id,name,age,currentAdress,permanantAdress);	
	}
	
}
