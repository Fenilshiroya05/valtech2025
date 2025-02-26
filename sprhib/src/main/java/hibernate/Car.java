package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

@Entity
public class Car {
	
	
	

//	2.@Id @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "carseq")
//	@SequenceGenerator(name="carseq", sequenceName = "car_seq",allocationSize = 1)
	
	//1.@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Id @GeneratedValue(strategy= GenerationType.TABLE,generator = "cartab")
	@TableGenerator(name="cartab", table="car_pk")
	private long id;
	private String manufacture;
	private String name;
	private int year;
	
	@Version
	private int version;
	
	public Car() {}
	
	
	public Car(long id, String manufacture, String name, int year) {
		this.id = id;
		this.manufacture = manufacture;
		this.name = name;
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", manufacture=" + manufacture + ", name=" + name + ", year=" + year + ", version="
				+ version + "]";
	}


	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	
}
