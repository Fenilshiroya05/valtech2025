package com.valtech.training.assignment.vos;

import org.springframework.stereotype.Component;

import com.valtech.training.assignment.entities.Item;


public record ItemVO(long id,String name,int maxQuantity,int currentQuantity,int reOrderQuantity) {
	
	
	public static ItemVO from(Item item) {
		return new ItemVO(item.getId(),item.getName(),item.getMaxQuantity(),item.getCurrentQuantity(),item.getReOrderValue());
	}
	public Item to() {
		return new Item(id,name,maxQuantity,currentQuantity,reOrderQuantity);
	}
	
	
}
