package assignment.classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Orders {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderseq")
	@SequenceGenerator(name = "orderseq",sequenceName = "order_seq",allocationSize = 1)
	private int id;
	private String status; 
	
	@ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id",referencedColumnName = "id")
	private Customer customer;
	
	@ManyToMany(targetEntity = Item.class, mappedBy = "orders")
	@JoinTable(name="order_items",
	joinColumns = @JoinColumn(name="order_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="item_id",referencedColumnName = "id"))
	private List<Item> items;
	
	@OneToMany(targetEntity = LineItem.class,mappedBy = "order")
	private List<LineItem> liveItems;
	
	public Orders() {}

	
	public void removeLiveItem(LineItem l) {
		l.setOrder(null);
		liveItems.remove(l);
	}
	
	public void addLiveItem(LineItem l) {
		if(liveItems==null) liveItems = new ArrayList<LineItem>();
		liveItems.add(l);
		l.setOrder(this);
	}

	public Orders(String status) {
		super();
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<LineItem> getLiveItems() {
		return liveItems;
	}

	public void setLiveItems(List<LineItem> liveItems) {
		this.liveItems = liveItems;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", customer=" + customer + "]";
	}

	
}
