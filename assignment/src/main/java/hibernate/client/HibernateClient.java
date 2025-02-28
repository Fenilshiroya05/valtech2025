package hibernate.client;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import assignment.classes.Customer;
import assignment.classes.Item;
import assignment.classes.LiveItem;
import assignment.classes.Order;



public class HibernateClient {

	public static void main(String[] args) {
		SessionFactory sesfac = new AnnotationConfiguration()
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Item.class)
				.addAnnotatedClass(LiveItem.class)
				.addAnnotatedClass(Order.class)
				.buildSessionFactory();
		Session ses = sesfac.openSession();
		Transaction tx = ses.beginTransaction(); 
		
		
		
		tx.commit();
		//System.out.println(car);
		ses.close();
		sesfac.close();
	}
	
	
}
