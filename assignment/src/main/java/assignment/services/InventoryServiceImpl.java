package assignment.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import assignment.classes.Customer;
import assignment.classes.Item;
import assignment.dao.CustomerDAO;
import assignment.dao.InventoryDAO;


@Transactional(propagation = Propagation.REQUIRED)
public class InventoryServiceImpl implements InventoryService {

	private InventoryDAO inventoryDAO;

	public void setInventoryDAO(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}
	
	@Override
	public void addInventory(Item item) {
		inventoryDAO.addInventory(item);
	}

	@Override
	public Item getInventory(int id) {
		return inventoryDAO.getInventory(id);
	}

	@Override
	public List<Item> getAll() {
		return inventoryDAO.getAll();
	}

	@Override
	public void updateInventory(Item item) {
		inventoryDAO.updateInventory(item);
	}

	@Override
	public void deleteInventory(int id) {
		inventoryDAO.deleteInventory(id);
	}

	@Override
	public void reorderItem(int id) {
		Item item=getInventory(id);
		if(item !=null && item.getQty()<item.getReorderQty()) {
			item.setQty(item.getMaxQty());
			updateInventory(item);
		}
	}

}
