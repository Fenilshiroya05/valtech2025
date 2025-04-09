package assignment.dao;

import java.util.List;

import assignment.classes.Orders;

public interface OrderDAO {

	void addOrder(Orders order);
	Orders getOrder(int id);
	List<Orders> getAll();
	void updateOrder(Orders order);
	void deleteOrder(int id);
}