package assignment.dao;

import java.util.List;

import assignment.classes.LineItem;


public interface LineItemDAO {
	void addLineItem(LineItem liveitem);
	LineItem getLineItem(int id);
	List<LineItem> getAll();
	void updateLineItem(LineItem lineitem);
	void deleteLineItem(int id);
}