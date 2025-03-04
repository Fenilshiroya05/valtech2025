package assignment.services;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import assignment.classes.Orders;
import assignment.dao.OrderDAO;

public class OrderServiceImpl implements OrderService {

	private OrderDAO orderDAO;
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	@Override
	public Orders getOrder(int id) {
		return orderDAO.getOrder(id);
	}

	@Override
	public void addOrder(Orders order) {
		orderDAO.addOrder(order);
	}

	@Override
	public List<Orders> getAll() {
		return orderDAO.getAll();
	}

	@Override
	public void updateOrder(Orders order) {
		orderDAO.updateOrder(order);
	}

	@Override
	public void deleteOrder(int id) {
		orderDAO.deleteOrder(id);
	}
	
	@Override
	public void statusOfOrder(int id, String status) {
		Orders order=getOrder(id);
		
		if(order !=null) {
			order.setStatus(status);
			updateOrder(order);
		}
	}

}
