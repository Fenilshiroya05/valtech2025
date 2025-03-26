package assignment.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import assignment.classes.Item;
import assignment.classes.LineItem;

@Repository
public class LineItemDAOImpl implements LineItemDAO {


	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addLineItem(LineItem lineitem) {
		new HibernateTemplate(sessionFactory).save(lineitem);	
	}

	@Override
	public LineItem getLineItem(int id) {
		return new HibernateTemplate(sessionFactory).load(LineItem.class, id);
	}

	@Override
	public List<LineItem> getAll() {
		return new HibernateTemplate(sessionFactory).find("from LineItem l");
	}

	@Override
	public void updateLineItem(LineItem liveitem) {
		new HibernateTemplate(sessionFactory).update(liveitem);
	}

	@Override
	public void deleteLineItem(int id) {
		new HibernateTemplate(sessionFactory).delete(getLineItem(id));
	}

}
