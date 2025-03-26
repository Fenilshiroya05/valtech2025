package classes;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order {
	
	public enum ORDERSTATUS {
		BOOKED,PACKED,DISPATCHED,DELIEVERED;
	}

	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderseq")
	@SequenceGenerator(name = "orderseq",sequenceName = "order_seq",allocationSize = 1)
	private int orderId;
	
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<LineItem> lineItems;
	
	@Enumerated(EnumType.STRING)
	private ORDERSTATUS status;
	
	public Order() {}

	public Order(Customer customer, ORDERSTATUS status) {
		super();
		this.customer = customer;
		this.status = status;
	}
	
	
	
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public ORDERSTATUS getStatus() {
		return status;
	}

	public void setStatus(ORDERSTATUS status) {
		this.status = status;
	}
	public void addLineItem(LineItem lineItem) {
		if(lineItems == null) lineItems = new ArrayList<LineItem>();
        lineItems.add(lineItem);
        lineItem.setOrder(this); 
    }
    
    public void removeLineItem(LineItem lineItem) {
        lineItems.remove(lineItem);
        lineItem.setOrder(null); 
    }

//	@Override
//	public String toString() {
//		return "Order [orderId=" + orderId + ", customer=" + customer.getId() + ", lineItems=" + lineItems + ", status="
//				+ status + "]";
//	}
    
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", status="
				+ status + "]";
	}
	
	
}