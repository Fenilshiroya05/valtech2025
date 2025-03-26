package classes;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String address;
	private String permanentAddress;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPermanent_add() {
		return permanentAddress;
	}
	public void setPermanent_add(String permanent_add) {
		this.permanentAddress = permanent_add;
	}
	
	public Customer() {}
	public Customer( String name, int age, String address, String permanent_add) {
		
		this.name = name;
		this.age = age;
		this.address = address;
		this.permanentAddress = permanent_add;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", permanent_add="
				+ permanentAddress + "]";
	}
	
	
	
}