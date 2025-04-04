package com.valtech.training.assignment.vos;

import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.valtech.training.assignment.entities.Customer;
import com.valtech.training.assignment.entities.Item;
import com.valtech.training.assignment.entities.LineItem;


public record LineItemVO(long itemId,int itemQuantity) {
	
}
