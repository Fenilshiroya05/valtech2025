package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import classes.Employee.EmployeeBuilder;
import classes.Employee.Gender;

public class Dept {
	private int id;
	private String name;
	private String location;
	
	public static List<Dept> allDept = new ArrayList<Dept>();
	
	public Dept() {}
	
	public Dept(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

	

	public static List<Dept> getAllDept() {
		return allDept;
	}

	public static void setAllDept(List<Dept> allDept) {
		Dept.allDept = allDept;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static DeptBuilder builder() {
		// EmployeeBuilder emps= new EmployeeBuilder(new Employee()); 
		return new DeptBuilder(new Dept());
	}
	
	
 public static class DeptBuilder{
	
	private Dept d;
	
	public DeptBuilder(Dept d) {
		this.d=d;
	}
	
	public Dept build() {
		allDept.add(d);
		return d;	
	}
	public DeptBuilder id(int id) {
		d.setId(id);
		return this;
	}
	public DeptBuilder name(String name) {
		d.setName(name);
		return this;
	}
	
	public DeptBuilder location(String location) {
		d.setLocation(location);
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(d);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeptBuilder other = (DeptBuilder) obj;
		return Objects.equals(d, other.d);
	}
	
}

	

}
