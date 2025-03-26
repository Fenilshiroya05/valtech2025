package classes;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class LineItem {
	
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineItemseq")
	@SequenceGenerator(name = "lineItemseq",sequenceName = "lineItem_seq",allocationSize = 1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	private int quantity;
	
	public LineItem() {}

	public LineItem(Order order, Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		
	}

	@Override
	public String toString() {
		return "LineItem [id=" + id + ", order=" + order.getOrderId() + ", item=" + item + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
}