package assignment.classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Order {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "ordid")
	private int odr_id;
	private String stauts; 
	
	@ManyToOne(targetEntity = Customer.class)
	private Customer customer;
	@OneToMany(targetEntity = LiveItem.class)
	private List<LiveItem> lineitems;
	
	
	private Customer cust;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int odr_id, String stauts, List<LiveItem> lineitems, Customer cust) {
		super();
		this.odr_id = odr_id;
		this.stauts = stauts;
		this.lineitems = lineitems;
		this.cust = cust;
	}
	public int getOdr_id() {
		return odr_id;
	}
	public void setOdr_id(int odr_id) {
		this.odr_id = odr_id;
	}
	public String getStauts() {
		return stauts;
	}
	public void setStauts(String stauts) {
		this.stauts = stauts;
	}
	public List<LiveItem> getLineitem() {
		return lineitems;
	}
	public void setLineitem(List<LiveItem> lineitem) {
		this.lineitems = lineitem;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
	
	
}
