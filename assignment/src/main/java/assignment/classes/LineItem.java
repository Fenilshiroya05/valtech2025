package assignment.classes;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class LineItem {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineitemseq")
	@SequenceGenerator(name = "lineitemseq",sequenceName = "lineitem_seq",allocationSize = 1)
	private int id;
	private int qty;
	
	@OneToOne(targetEntity = Item.class)
	@JoinColumn(name =  "item_id")
	private Item item;
	
	@ManyToOne(targetEntity = Orders.class)
	@JoinColumn(name="order_id",referencedColumnName = "id")
	private Orders order;
	
	public LineItem() {}
		
	
	public LineItem(Item item, int qty) {
		this.item=item;
		this.qty=qty;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "LiveItem [id=" + id + ", qty=" + qty + "]";
	}
	
}
