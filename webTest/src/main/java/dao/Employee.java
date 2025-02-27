package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.management.modelmbean.InvalidTargetObjectTypeException;

public class Employee implements Comparable<Employee>{
	
	private long id;
	private String name;
	private int age;
	private float salary;
	private int level;
	private int experience;
	private Gender gender;
	private int dept_id;
	public static List<Employee> allEmployee = new ArrayList<Employee>();
	private static Map<Gender,List<Employee>> getEmployeeMap = new HashMap<Gender,List<Employee>>();
	
	public enum Gender{
		MALE,
		FEMALE,
		OTHER;
	}
	// parameterized constructor
	public Employee(long id, String name, int age, float salary, int level, int experiance, String gender,int dept_id) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.level = level;
		this.experience = experiance;
		this.gender = Gender.valueOf(gender.toUpperCase());
		this.dept_id=dept_id;
		allEmployee.add(this);
		
	}
// default constructor
	public Employee() {}

	
	 
		
		
	
	// ----------------------------------------  Builder Class-------------------------------------
		
		public static EmployeeBuilder builder() {
			// EmployeeBuilder emps= new EmployeeBuilder(new Employee()); 
			return new EmployeeBuilder(new Employee());
		}
		
		
	 public static class EmployeeBuilder{
		
		private Employee emp;
		
		public EmployeeBuilder(Employee emp) {
			this.emp=emp;
		}
		
		public Employee build() {
			allEmployee.add(emp);
			return emp;	
		}
		public EmployeeBuilder id(long id) {
			emp.setId(id);
			return this;
		}
		public EmployeeBuilder name(String name) {
			emp.setName(name);
			return this;
		}
		public EmployeeBuilder age(int age) {
			emp.setAge(age);
			return this;
		}
		public EmployeeBuilder salary(float salary) {
			emp.setSalary(salary);
			return this;
		}
		public EmployeeBuilder level(int level) {
			emp.setLevel(level);
			return this;
		}
		public EmployeeBuilder experience(int experience) {
			emp.setExperience(experience);
			return this;
		}
		public EmployeeBuilder gender(String gender) {
			emp.setGender(Gender.valueOf(gender.toUpperCase()));
			return this;
		}
		public EmployeeBuilder dept_id(int dept_id) {
    		emp.setDept_id(dept_id);
    		return this;
    	}
		
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(age, experience, gender, id, level, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && experience == other.experience && gender == other.gender && id == other.id
				&& level == other.level && Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}

	@Override
	public String toString() {
		return  new StringBuilder().append("ID : ")
								.append(id)
								.append(" Name : ")
								.append(name)
								.append(" Age : ")
								.append(age)
								.append(" Salary : ")
								.append(salary)
								.append(" Experience : ")
								.append(experience)
								.append(" Gender : ")
								.append(gender)
								.append(" Department ID :")
								.append(dept_id)
								.toString();
	}

	
	
	@Override
	public int compareTo(Employee o) {

		if(this.level!=o.level)
			return level-o.level;
		else if(this.experience!=o.experience)
			return experience-o.experience;
		int genderCom = this.gender.compareTo(o.gender);
		if(genderCom!=0){
			return genderCom;
		}else 
			return (int) (salary-o.salary);
	}
	
	
	
	
	public static void main(String[] args) {
//		long id, String name, int age, float salary, int level, int experiance, Gender gender
		//Employee emp =new Employee(1,"Fenil",21,20542,2,2,Gender.MALE);
		//System.out.println("Employee 1: "+ emp.toString());
	}
	
	
	
	
	//----------------------------------------- Getter Setter for Employee class------------------------------
		public long getId() {
			return id;
		}
		public void setId(long id) {
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
		public float getSalary() {
			return salary;
		}
		public void setSalary(float salary) {
			this.salary = salary;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
		public int getExperience() {
			return experience;
		}
		public void setExperience(int experience) {
			this.experience = experience;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public int getDept_id() {
			return dept_id;
		}
		public void setDept_id(int dept_id) {
			this.dept_id = dept_id;
		}
		
		

}
