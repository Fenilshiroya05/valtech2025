package hibernate.client;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import classes.Customer;
import classes.Item;
import classes.LineItem;
import classes.Order;
import classes.Order.ORDERSTATUS;
import dao.ItemDAO;
import dao.LineItemDAO;
import dao.OrderDAO;
import services.CustomerService;
import services.InventoryService;
import services.OrderService;



public class HibernateClient {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext("hibernate.xml");
		CustomerService cs = ct.getBean(CustomerService.class);
		ItemDAO ih = ct.getBean(ItemDAO.class);
		OrderDAO od = ct.getBean(OrderDAO.class);
        OrderService os = ct.getBean(OrderService.class);
        LineItemDAO ld = ct.getBean(LineItemDAO.class);
        InventoryService invService = ct.getBean(InventoryService.class);
 
        
//        Customer c1 = new Customer("Alice Johnson", 28, "Chicago", "San Francisco");
//        Customer c2 = new Customer("Rajesh Kumar", 32, "Bangalore", "Mumbai");
     //   Customer c3 = new Customer("Sophia Lee", 26, "Seattle", "Boston");
//        Customer c4 = new Customer("Ankit Verma", 24, "Pune", "Hyderabad");
//
//        cs.save(c1);
//        cs.save(c2);
//        cs.save(c3);
//        cs.save(c4);
//        System.out.println("Customers added successfully.");
//        
//        
     // Item i1 = new Item("Oreo", "Chocolate Biscuit", 8, 3, 15);
//        Item i2 = new Item("Smartphone", "Samsung Galaxy S21", 15, 5, 30);
//        Item i3 = new Item("Keyboard", "Mechanical Keyboard", 40, 10, 80);
//        Item i4 = new Item("Parle-G", "Glucose Biscuit", 60, 25, 120);
//        Item i5 = new Item("Laptop", "Lenovo ThinkPad", 90, 15, 180);
//        Item i6 = new Item("Monitor", "LG 24-inch", 150, 40, 300);
//
//        ih.save(i1);
//        ih.save(i2);
//        ih.save(i3);
//        ih.save(i4);
//        ih.save(i5);
//        ih.save(i6);
//         System.out.println("Items added successfully.");
       
       
       
//      
// 		Customer cus = cs.get(1);
// 		od.save(new Order(cus,ORDERSTATUS.PACKED));
// 		cus.setPermanent_add("Delhi");
// 		cs.update(cus);

         
         


//        LineItem lineItem = new LineItem();
//        lineItem.setItem(ih.get(1));
//        lineItem.setQuantity(5);
//
//        Order order = new Order();
//        order.setCustomer(cs.get(1));
//        order.setStatus(ORDERSTATUS.BOOKED);
//        order.addLineItem(lineItem);
//
//        os.placeOrder(order);
//        System.out.println("Order placed: " + order);
//       
        
//       
//       Order existingOrder = od.getOrderById(1);  
//       os.updateOrderStatus(existingOrder.getOrderId(), ORDERSTATUS.DISPATCHED);
//       System.out.println("Order status updated to DISPATCHED for order ID: " + existingOrder.getOrderId());

        
//       Item updatedItem = ih.get(1);  
//       System.out.println("Updated inventory for item: " + updatedItem);
        
        
        
//        
//        System.out.println("All Customers:");
//        cs.getAll().forEach(System.out::println);
//
//        System.out.println("All Items:");
//        ih.getAll().forEach(System.out::println);
//
//        System.out.println("All Orders:");
//        os.getAllOrders().forEach(o -> {
//            System.out.println(o);
//            o.getLineItems().forEach(System.out::println);
//        });
//

     
        


	}
}