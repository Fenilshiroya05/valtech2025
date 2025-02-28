package assignment.classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@Entity
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "custseq")
	private int cust_id;
	
	private String cust_name;
	private int age;
	private String addresss;
	private String p_address;
	
	@OneToMany(targetEntity = Order.class,mappedBy = "order")
	private List<Order> order;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(int cust_id, String cust_name, int age, String addresss, String p_address, List<Order> order) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.age = age;
		this.addresss = addresss;
		this.p_address = p_address;
		this.order = order;
	}

	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddresss() {
		return addresss;
	}
	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	
	
	
}
