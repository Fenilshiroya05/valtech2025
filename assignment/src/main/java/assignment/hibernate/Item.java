package assignment.hibernate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "invid")
	private int inv_id;
	
	private String inv_name;
	private String desc;
	private int qty;
	private int reorder_qty;
	private int max_qty;
	
	@ManyToMany(targetEntity = Order.class)
	private List<Order> orders;
	
	@OneToOne(targetEntity = LiveItem.class)
	private List<LiveItem> liveitems;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Item(int inv_id, String inv_name, String desc, int qty, int reorder_qty, int max_qty, List<Order> orders,
			List<LiveItem> liveitems) {
		super();
		this.inv_id = inv_id;
		this.inv_name = inv_name;
		this.desc = desc;
		this.qty = qty;
		this.reorder_qty = reorder_qty;
		this.max_qty = max_qty;
		this.orders = orders;
		this.liveitems = liveitems;
	}



	public int getInv_id() {
		return inv_id;
	}

	public void setInv_id(int inv_id) {
		this.inv_id = inv_id;
	}

	public String getInv_name() {
		return inv_name;
	}

	public void setInv_name(String inv_name) {
		this.inv_name = inv_name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getReorder_qty() {
		return reorder_qty;
	}

	public void setReorder_qty(int reorder_qty) {
		this.reorder_qty = reorder_qty;
	}

	public int getMax_qty() {
		return max_qty;
	}

	public void setMax_qty(int max_qty) {
		this.max_qty = max_qty;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<LiveItem> getLiveitems() {
		return liveitems;
	}

	public void setLiveitems(List<LiveItem> liveitems) {
		this.liveitems = liveitems;
	}
	
	
	
}
