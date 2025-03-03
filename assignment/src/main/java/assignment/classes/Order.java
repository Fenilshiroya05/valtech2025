package assignment.classes;

import java.util.List;

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

@Entity
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderseq")
	@SequenceGenerator(name = "orderseq",sequenceName = "order_seq",allocationSize = 1)
	private int id;
	private String stauts; 
	
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name="customer_id",referencedColumnName = "id")
	private Customer customer;
	
	@ManyToMany(targetEntity = Item.class, mappedBy = "orders")
	@JoinTable(name="order_items",
	joinColumns = @JoinColumn(name="order_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="item_id",referencedColumnName = "id"))
	private List<Item> items;
	
	@OneToMany(targetEntity = LiveItem.class,mappedBy = "order")
	private List<LiveItem> liveItems;
	
	public Order() {}

	public Order(String stauts) {
		this.stauts = stauts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStauts() {
		return stauts;
	}

	public void setStauts(String stauts) {
		this.stauts = stauts;
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

	public List<LiveItem> getLiveItems() {
		return liveItems;
	}

	public void setLiveItems(List<LiveItem> liveItems) {
		this.liveItems = liveItems;
	}

}
