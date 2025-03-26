package services;



import java.util.List;
import classes.Order;
import classes.Order.ORDERSTATUS;


public interface OrderService {
	
	void placeOrder(Order order);
	void updateOrderStatus(int orderId,ORDERSTATUS status);
	Order getOrderById(int orderId);
	List<Order> getAllOrders();
}