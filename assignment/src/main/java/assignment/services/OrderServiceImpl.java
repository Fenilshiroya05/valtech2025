package assignment.services;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import assignment.classes.Customer;
import assignment.classes.Item;
import assignment.classes.LineItem;
import assignment.classes.Orders;
import assignment.dao.CustomerDAO;
import assignment.dao.InventoryDAO;
import assignment.dao.LineItemDAO;
import assignment.dao.OrderDAO;

public class OrderServiceImpl implements OrderService {

	private OrderDAO orderDAO;
	private CustomerDAO customerDAO;
	private InventoryDAO inventoryDAO;
	private LineItemDAO lineItemDAO;
	
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
	
	
	
//	@Override
//    public void placeOrder(Orders order, List<Integer> itemIds, int customerId) {
//        Customer customer = customerDAO.getCustomer(customerId);
//        if (customer != null) {
//            order.setCustomer(customer);
//            order.setStatus("PENDING");
//            addOrder(order);
//
//            for (int itemId : itemIds) {
//            	
//                Item item = inventoryDAO.getInventory(itemId);
//                if (item != null) {
//                    order.getItems().add(item);
//                    LineItem lineItem = new LineItem(item, item.getQty());
//                    lineItem.setOrder(order);
//                    lineItemDAO.addLiveItem(lineItem);
//                }
//            }
//            updateOrder(order);
//        }
//    }

}
