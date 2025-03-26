package dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import classes.Order;

public class OrderDAOImpl implements OrderDAO{

	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Order o) {
		new HibernateTemplate(sessionFactory).save(o);
		
	}

	@Override
	public void update(Order o) {
		new HibernateTemplate(sessionFactory).update(o);
		
	}

	@Override
	public Order getOrderById(int id) {
		
		return new HibernateTemplate(sessionFactory).load(Order.class, id);
	}

	@Override
	public List<Order> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Order o");
	}

}