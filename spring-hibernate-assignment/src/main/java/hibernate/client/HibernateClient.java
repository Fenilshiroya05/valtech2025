package hibernate.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import assignment.classes.Customer;
import assignment.classes.Item;
import assignment.classes.LineItem;
import assignment.classes.Orders;
import assignment.dao.LineItemDAO;
import assignment.dao.OrderDAO;
import assignment.services.CustomerService;
import assignment.services.InventoryService;
import assignment.services.OrderService;


public class HibernateClient {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("ass-hib-ann.xml");
		
		CustomerService cs=ctx.getBean(CustomerService.class);
		InventoryService is=ctx.getBean(InventoryService.class);
		OrderService os=ctx.getBean(OrderService.class);
		LineItemDAO lDAO=ctx.getBean(LineItemDAO.class);
		

	
	//	Customer c1= new Customer("FENIL",21,"AHM","SRT");
//		Customer c2= new Customer("RAJ",21,"RJT","AHM");
//		Customer c3= new Customer("KRISHNA",21,"VDA","DIU");
//		Customer c4= new Customer("SHIV",21,"AMR","HMT");
	//	Customer c5= new Customer("RADHE",23,"WB","DD");
		
		
//	    cs.addCustomer(c1);
//		cs.addCustomer(c2);
//		cs.addCustomer(c3);
//		cs.addCustomer(c4);
		//cs.addCustomer(c5);
		
		//cs.deleteCustomer(15);
	
        System.out.println("All Customers: " + cs.getAll());
        
        
//        c1.setName("FENIL SHIROYA");
//        cs.updateCustomer(c1);
//        Customer updatedCustomer = cs.getCustomer(c1.getId());
//        System.out.println("Updated Customer: " + updatedCustomer.getName());
	
		Item i1=new Item("LAPTOP","XZT",10,4,15);
		Item i2=new Item("PC","i5",6,2,10);
		//Item i3=new Item("MOUSE","WIRELESS",5,2,8);
//		Item i4=new Item("KEYBOARD","WIRED",5,2,6);
//
//		is.addInventory(i1);
//		is.addInventory(i2);
//		is.addInventory(i3);
//		is.addInventory(i4);
		
        System.out.println("All Items: " + is.getAll());
		
//		Customer c6= new Customer("FENIL",21,"AHM","SRT");
//		cs.addCustomer(c6);
        
       // Orders order = new Orders();
       // os.placeOrder(order, Arrays.asList(i1.getId(), i2.getId()), c6.getId());

        
//          Orders order = new Orders("PENDING");
//          order.setCustomer(c5);
//          os.addOrder(order);
        
        System.out.println("All Orders: " + os.getAll());
		
		//os.deleteOrder(5);
       
      //  Orders order=new Orders();
        
        
//        os.statusOfOrder(os.getOrder(10).getId(), "COMPLETED");
//        Orders updatedOrder = os.getOrder(os.getOrder(10).getId());
//        System.out.println("Updated Order Status: " + updatedOrder.getStatus());

        
//        Item i5=new Item("BISCUIT","CREAM",3,2,6);
//        is.addInventory(i5);
        
//		LineItem l1= new LineItem(i5,2);
//		lDAO.addLiveItem(l1);
//		
	    System.out.println("All Line Items: " + lDAO.getAll());

//	    lDAO.deleteLineItem(l1.getId());
//        System.out.println("Deleted Line Item with ID: " + l1.getId());

//		Item i5=new Item("MOUSE","WIRELESS",5,2,8);
//		is.addInventory(i5);//same qty because 5>2 (qty>reorderqty)
	    
	    
//	    Item i6=new Item("CHIPS","BANANA",2,5,6);
//		is.addInventory(i6); // here set new qty as max qty because qty<reorderQty
		
//	    is.reorderItem(i6.getId());
//        Item reorderedItem = is.getInventory(i6.getId());
//        System.out.println("Reordered Item: " + reorderedItem.getName() + ", New Quantity: " + reorderedItem.getQty());
	    
        System.out.println("All Items: " + is.getAll());
		
		ctx.close();
	}
	
}
