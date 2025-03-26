package dao;



import java.util.List;

import classes.LineItem;

public interface LineItemDAO {
	void save(LineItem lineItem);                
    void update(LineItem lineItem);               
    void delete(int id);              
    LineItem getById(int id);              
    List<LineItem> getAll();                     
    List<LineItem> getByOrderId(int orderId);   
	
}