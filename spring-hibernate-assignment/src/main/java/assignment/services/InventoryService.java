package assignment.services;

import java.util.List;

import assignment.classes.Item;


public interface InventoryService {
	
	void addInventory(Item item);
	Item getInventory(int id);
	List<Item> getAll();
	void updateInventory(Item item);
	void deleteInventory(int id);
	void reorderItem(int id);
	
}