package com.valtech.training.assignment.vos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.valtech.training.assignment.entities.Customer;
import com.valtech.training.assignment.entities.LineItem;
import com.valtech.training.assignment.entities.Orders;
import com.valtech.training.assignment.entities.Orders.OrderStatus;


public record OrderVO(long id,OrderStatus orderStatus,List<LineItemVO> lineItems,long customerId) {
	
	
	public static OrderVO from(Orders o) {
		List<LineItemVO>lineItemVO=o.getLineItems().stream().map(w->new LineItemVO(w.getItem().getId(),w.getOrderQuantity()))
				.collect(Collectors.toList());
		return new OrderVO(o.getId(),o.getOrderStatus(),lineItemVO,o.getCustomer().getId());
		
	}

	public Orders to() {
		Orders o=new Orders();
		o.setId(id);
		o.setOrderStatus(orderStatus);
		return new Orders();
	}
	
	
	
}
