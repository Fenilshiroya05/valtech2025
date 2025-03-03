package hibernate.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import assignment.classes.Customer;
import assignment.classes.Item;
import assignment.classes.LiveItem;
import assignment.classes.Order;
import assignment.dao.LiveItemDAO;
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
		LiveItemDAO lDAO=ctx.getBean(LiveItemDAO.class);
		

	
//		Customer c1= new Customer("FENIL",21,"AHM","SRT");
//		Customer c2= new Customer("RAJ",21,"RJT","AHM");
//		Customer c3= new Customer("KRISHNA",21,"VDA","DIU");
//		Customer c4= new Customer("SHIV",21,"AMR","HMT");
//		
//		cs.addCustomer(c1);
//		cs.addCustomer(c2);
//		cs.addCustomer(c3);
//		cs.addCustomer(c4);
		
		//cs.deleteCustomer(9);
	
		Item i1=new Item("LAPTOP","XZT",10,4,15);
		Item i2=new Item("PC","i5",6,2,10);
		Item i3=new Item("MOUSE","WIRELESS",5,2,8);
		Item i4=new Item("KEYBOARD","WIRED",5,2,6);
//
//		is.addInventory(i1);
//		is.addInventory(i2);
//		is.addInventory(i3);
//		is.addInventory(i4);
		
		LiveItem l1= new LiveItem(i1,2);
		lDAO.addLiveItem(l1);
		
		
		ctx.close();
	}
	
	
}
