 package assignment.classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="customer1")
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custseq")
	@SequenceGenerator(name = "custseq",sequenceName = "cust_seq",allocationSize = 1)
	private int id;
	private String name;
	private int age;
	private String addresss;
	private String permanantAddress;
	
	@OneToMany(targetEntity = Orders.class,mappedBy = "customer")
	private List<Orders> orders;
	
	public Customer() {}
	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", addresss=" + addresss
				+ ", permanantAddress=" + permanantAddress + "]";
	}


	public Customer(String name, int age, String addresss, String permanantAddress) {
		super();
		this.name = name;
		this.age = age;
		this.addresss = addresss;
		this.permanantAddress = permanantAddress;
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

	public String getPermanantAddress() {
		return permanantAddress;
	}

	public void setPermanantAddress(String permanantAddress) {
		this.permanantAddress = permanantAddress;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	
}
