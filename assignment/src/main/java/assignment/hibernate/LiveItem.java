package assignment.hibernate;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LiveItem {

	
	private int line_id;
	private int line_qty;
	
	@OneToOne(targetEntity = Item.class,mappedBy = "item")
	private Item item;
	@ManyToOne(targetEntity = Order.class)
	private Order order;
	
	public LiveItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LiveItem(int line_id, int line_qty, Item item, Order order) {
		super();
		this.line_id = line_id;
		this.line_qty = line_qty;
		this.item = item;
		this.order = order;
	}
	public int getLine_id() {
		return line_id;
	}
	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}
	public int getLine_qty() {
		return line_qty;
	}
	public void setLine_qty(int line_qty) {
		this.line_qty = line_qty;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
}
