package asssignment.service;

import java.util.List;

import assignment.hibernate.Item;


public interface InventorySevice {
	
	void save(Item e);
	void update(Item e);
	void delete(int id);
	
}