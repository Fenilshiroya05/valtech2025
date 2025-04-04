package com.valtech.training.assignment.services;

import java.util.List;

import com.valtech.training.assignment.entities.Orders.OrderStatus;
import com.valtech.training.assignment.vos.OrderViewVO;
import com.valtech.training.assignment.vos.OrderVO;

public interface OrderService {

	OrderVO placeOrder(OrderVO orderVO);

	List<OrderVO> getOrdersByCustomerId(long id);

	List<OrderVO> getAllOrders();

	OrderStatus getOrderStatus(long id);

	List<OrderViewVO> getOrderById(long id);

	void updateOrderStatus(long id, OrderStatus orderStatus);


}