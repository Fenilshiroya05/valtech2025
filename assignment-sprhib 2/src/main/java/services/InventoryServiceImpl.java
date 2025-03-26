package services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import classes.Item;
import dao.ItemDAO;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private ItemDAO itemDAO;

	@Override
	public void updateInventory(int itemId,int newQuantity) {
		Item item = itemDAO.get(itemId);
        
        if (item != null) {
            item.setQuantity(newQuantity);
            item.setReorder(Math.max(item.getMaxQuantity() - newQuantity, 0)); 
            
            itemDAO.update(item);
            }
		
	}

	@Override
	public void resetInventory(Item item) {
		item.setQuantity(item.getMaxQuantity());
		item.setReorder(0);
		itemDAO.update(item);
	}
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	

}