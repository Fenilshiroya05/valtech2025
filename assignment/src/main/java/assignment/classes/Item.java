package assignment.classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "itemseq")
	@SequenceGenerator(name = "itemseq",sequenceName = "item_seq",allocationSize = 1)
	private int id;
	
	private String name;
	private String description;
	private int qty;
	private int reorderQty;
	private int maxQty;
	
	@ManyToMany(targetEntity = Orders.class)
	private List<Orders> orders;
	
	@OneToOne(targetEntity = LiveItem.class,mappedBy = "item")
	private LiveItem liveItem;
	
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Item(String name, String description, int qty, int reorderQty, int maxQty) {
		super();
		this.name = name;
		this.description = description;
		this.qty = qty;
		this.reorderQty = reorderQty;
		this.maxQty = maxQty;
		this.liveItem=new LiveItem(this,qty);
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getReorderQty() {
		return reorderQty;
	}

	public void setReorderQty(int reorderQty) {
		this.reorderQty = reorderQty;
	}

	public int getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(int maxQty) {
		this.maxQty = maxQty;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public LiveItem getLiveItem() {
		return liveItem;
	}

	public void setLiveItem(LiveItem liveItem) {
		this.liveItem = liveItem;
	}



	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", qty=" + qty + ", reorderQty="
				+ reorderQty + ", maxQty=" + maxQty + "]";
	}

	
}
