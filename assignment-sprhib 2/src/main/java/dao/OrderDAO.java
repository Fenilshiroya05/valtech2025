package dao;



import java.util.List;

import classes.Order;

public interface OrderDAO {
	void save(Order o);
	void update(Order o);
	Order getOrderById(int id);
	List<Order> getAll();
}