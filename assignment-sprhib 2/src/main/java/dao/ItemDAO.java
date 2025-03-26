package dao;



import java.util.List;

import classes.Item;

public interface ItemDAO {
	
	void save(Item i);
	void update(Item i);
	void delete(int id);
	Item get(int id);
	List<Item> getAll();

}