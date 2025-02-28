package assignment.services;

import java.util.List;

import assignment.classes.Item;


public interface InventorySevice {
	
	void save(Item e);
	void update(Item e);
	void delete(int id);
	
}