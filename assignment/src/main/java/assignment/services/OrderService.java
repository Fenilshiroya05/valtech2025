package assignment.services;

import java.util.List;

import assignment.classes.Orders;

public interface OrderService {

	void statusOfOrder(int id, String status);
	void addOrder(Orders order);
	Orders getOrder(int id);
	List<Orders> getAll();
	void updateOrder(Orders order);
	void deleteOrder(int id);
}