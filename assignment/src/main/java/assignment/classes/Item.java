package assignment.classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy="item",fetch = FetchType.EAGER)
	private List<LineItem>lineItems;
	
	
	
	public Item() {}

	
	
	public Item(String name, String description, int qty, int reorderQty, int maxQty) {
		super();
		this.name = name;
		this.description = description;
		this.qty = qty;
		this.reorderQty = reorderQty;
		this.maxQty = maxQty;
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



	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", qty=" + qty + ", reorderQty="
				+ reorderQty + ", maxQty=" + maxQty + "]";
	}

	
}
