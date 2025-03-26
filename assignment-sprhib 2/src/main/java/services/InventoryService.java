package services;

import classes.Item;

public interface InventoryService {
	
	void resetInventory(Item item);
	void updateInventory(int itemid,int newQuantity);

}