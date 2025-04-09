package hibernate.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import assignment.classes.Customer;
import assignment.classes.Item;
import assignment.classes.LineItem;
import assignment.classes.Orders;
import assignment.dao.LineItemDAO;
import assignment.services.CustomerService;
import assignment.services.InventoryService;
import assignment.services.OrderService;

class HibernateTest {

	@Test
	void test() {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("ass-hib-ann.xml");
		CustomerService cs=ctx.getBean(CustomerService.class);
		InventoryService is=ctx.getBean(InventoryService.class);
		OrderService os=ctx.getBean(OrderService.class);
		LineItemDAO lDAO=ctx.getBean(LineItemDAO.class);
		
		Customer c1= new Customer("ABC", 21, "AVC", "GJ");
		cs.addCustomer(c1);
		
		Item i1= new Item("BISCUIT","XYZ", 2, 1, 4);
		is.addInventory(i1);
	
		
		Orders o= new Orders();
		o.setStatus("PENDING");
		o.setCustomer(c1);
		os.addOrder(o);
		
		
		
//		assertEquals(7, cs.getAll().size());
//		assertEquals(23, cs.getCustomer(28).getAge());
//		
//		assertEquals(7, is.getAll().size());
//		assertEquals("PC", is.getInventory(2).getName());
//		
//		assertEquals("COMPLETED", os.getOrder(10).getStatus());
//		assertEquals(1, os.getAll().size());
//		
//		assertEquals(2, lDAO.getLineItem(8).getQty());
//		assertEquals(5, lDAO.getLineItem(8).getItem().getId());
		//assertEquals(1, lDAO.getAll().size());
	}

}
