package hibernate.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import assignment.dao.LiveItemDAO;
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
		LiveItemDAO lDAO=ctx.getBean(LiveItemDAO.class);
		
		assertEquals(6, cs.getAll().size());
		assertEquals(23, cs.getCustomer(28).getAge());
		
		assertEquals(7, is.getAll().size());
		assertEquals("PC", is.getInventory(2).getName());
		
		assertEquals("COMPLETED", os.getOrder(10).getStatus());
		assertEquals(1, os.getAll().size());
		
		assertEquals(2, lDAO.getLiveItem(8).getQty());
		assertEquals(5, lDAO.getLiveItem(8).getItem().getId());
		assertEquals(1, lDAO.getAll().size());
	}

}
