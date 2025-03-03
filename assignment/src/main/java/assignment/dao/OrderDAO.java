package assignment.dao;

import java.util.List;

import assignment.classes.Order;

public interface OrderDAO {

	void addOrder(Order order);
	Order getOrder(int id);
	List<Order> getAll();
	void updateOrder(Order order);
	void deleteOrder(int id);
}