package dao;



import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import classes.LineItem;

public class LineItemDAOImpl implements LineItemDAO{

	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public void save(LineItem lineItem) {
		new HibernateTemplate(sessionFactory).save(lineItem);
		
	}

	@Override
	public void update(LineItem lineItem) {
		new HibernateTemplate(sessionFactory).update(lineItem);
		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(id);
		
	}

	@Override
	public LineItem getById(int id) {
		return new HibernateTemplate(sessionFactory).load(LineItem.class, id);
		
	}

	@Override
	public List<LineItem> getAll() {
		return new HibernateTemplate(sessionFactory).find("from LineItem lineItem");

	}

	@Override
	public List<LineItem> getByOrderId(int orderId) {
		return new HibernateTemplate(sessionFactory).
				find("from LineItem where orderId = :orderId","orderId",orderId);

	}
		
}