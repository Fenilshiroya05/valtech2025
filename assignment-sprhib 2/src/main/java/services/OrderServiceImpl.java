package services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import classes.Item;
import classes.LineItem;
import classes.Order;
import classes.Order.ORDERSTATUS;
import dao.ItemDAO;
import dao.OrderDAO;



@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void placeOrder(Order order) {
		for(LineItem lineItem : order.getLineItems()) {
			Item item = itemDAO.get(lineItem.getItem().getId());
			
			if(item == null) {
				throw new RuntimeException("Item not found with ID: "+lineItem.getId());
			}
			int updatedQuantity = item.getQuantity() - lineItem.getQuantity();
			
			if(updatedQuantity < 0) {
				throw new RuntimeException("Not enough stock available for item : " + item.getName());
			}
			item.setQuantity(updatedQuantity);
			itemDAO.update(item);
		}
		orderDAO.save(order);
	}

	@Override
	@Transactional
	public void updateOrderStatus(int orderId, ORDERSTATUS status) {
		Order order = orderDAO.getOrderById(orderId);
		if(order != null) {
			order.setStatus(status);
			orderDAO.update(order);
		}else {
			throw new RuntimeException("Order not found with ID: "+ orderId);
		}
	}

	@Override
	public Order getOrderById(int orderId) {
		return orderDAO.getOrderById(orderId);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderDAO.getAll();
	}
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

}