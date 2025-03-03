package assignment.services;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import assignment.classes.Order;
import assignment.dao.OrderDAO;

public class OrderServiceImpl implements OrderService {

	private OrderDAO orderDAO;
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	@Override
	public Order getOrder(int id) {
		return orderDAO.getOrder(id);
	}

	@Override
	public void addOrder(Order order) {
		orderDAO.addOrder(order);
	}

	@Override
	public List<Order> getAll() {
		return orderDAO.getAll();
	}

	@Override
	public void updateOrder(Order order) {
		orderDAO.updateOrder(order);
	}

	@Override
	public void deleteOrder(int id) {
		orderDAO.deleteOrder(id);
	}
	
	@Override
	public void statusOfOrder(int id, String status) {
		Order order=getOrder(id);
		
		if(order !=null) {
			order.setStauts(status);
			updateOrder(order);
		}
	}

}
