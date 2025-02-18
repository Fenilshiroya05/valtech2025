package Assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Employee implements Comparable<Employee>{
	
	private long id;
	private String name;
	private int age;
	private float salary;
	private int level;
	private int experiance;
	private Gender gender;
	public static List<Employee> allEmployee = new ArrayList<Employee>();
	private static Map<Gender,List<Employee>> getEmployeeMap = new HashMap<Gender,List<Employee>>();
	
	public enum Gender{
		MALE,
		FEMALE,
		OTHER;
	}
	// parameterized constructor
	public Employee(long id, String name, int age, float salary, int level, int experiance, Gender gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.level = level;
		this.experiance = experiance;
		this.gender = gender;
		allEmployee.add(this);
		
	}
// default constructor
	public Employee() {}

	
	  public static String getEmployeebyLevels(int level){ 
		   List<Employee> empByLevels= allEmployee.stream().filter(e-> e.level==level).collect(Collectors.toList());
		   System.out.println("List By Levels = "+ empByLevels);
		   double emp1= allEmployee.stream().filter(e-> e.level==level).mapToDouble(Employee::getSalary).sum();
		   if(emp1>0) {
				  return "Total Sum of salary by Level  = "+ emp1;
			  }
			  else 
			  {
				  return level+" not available in DATA";
			  }
	   }
	   
	   public static double getEmployeebyGender(Gender gender) {
		   List<Employee> empByGender= allEmployee.stream().filter(e-> e.gender.equals(gender)).collect(Collectors.toList());
		   System.out.println("List By Levels = "+ empByGender);
		   return allEmployee.stream().filter(e-> e.gender.equals(gender)).mapToDouble(Employee::getSalary).sum();
	   }
	   
	  public static String getEmployeeByName(String name) {
		  List<Employee> empByName= allEmployee.stream().filter(e-> e.name.equals(name)).collect(Collectors.toList());
		  System.out.println("List By Levels = "+ empByName);
		  double emp1=allEmployee.stream().filter(e-> e.name.equals(name)).mapToDouble(Employee::getSalary).sum();
		  if(emp1>0) {
			  return "Total Sum of salary = "+ emp1;
		  }
		  else 
		  {
			  return name+" not available in DATA";
		  }
		  
	   }
	   public static String getEmployeeByLevelAndGender(int level,Gender gender) {
		   List<Employee> empByName= allEmployee.stream().filter(e-> e.gender.equals(gender) && e.level==level) .collect(Collectors.toList());
		   System.out.println("List By Levels = "+ empByName);
		   double emp1=allEmployee.stream().filter(e-> e.gender.equals(gender) && e.level==level).mapToDouble(Employee::getSalary).sum();
		   if(emp1>0) {
				  return "Total Sum of salary by Level and Gender = "+ emp1;
			  }
			  else 
			  {
				  return "Not available in DATA";
			  }
	   }

		
		public static Map<Gender,List<Employee>> getEmployeeByGender() {
			
			return allEmployee.stream().collect(Collectors.groupingBy(e->e.gender));
//			getEmployeeMap.put(Gender.MALE, allEmployee.stream().filter(e->e.gender.equals(Gender.MALE)).collect(Collectors.toList()));
//			getEmployeeMap.put(Gender.FEMALE, allEmployee.stream().filter(e->e.gender.equals(Gender.FEMALE)).collect(Collectors.toList()));
//			getEmployeeMap.put(Gender.OTHER, allEmployee.stream().filter(e->e.gender.equals(Gender.OTHER)).collect(Collectors.toList()));
//			return getEmployeeMap;
		}

		
		
	
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
		public EmployeeBuilder experience(int experiance) {
			emp.setExperiance(experiance);
			return this;
		}
		public EmployeeBuilder gender(String gender) {
			emp.setGender(Gender.valueOf(gender));
			return this;
		}
		
		
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(age, experiance, gender, id, level, name, salary);
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
		return age == other.age && experiance == other.experiance && gender == other.gender && id == other.id
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
								.append(" Experiance : ")
								.append(experiance)
								.append(" Gender : ")
								.append(gender)
								.toString();
	}

	
	
	@Override
	public int compareTo(Employee o) {

		if(this.level!=o.level)
			return level-o.level;
		else if(this.experiance!=o.experiance)
			return experiance-o.experiance;
		int genderCom = this.gender.compareTo(o.gender);
		if(genderCom!=0){
			return genderCom;
		}else 
			return (int) (salary-o.salary);
	}
	
	
	
	
	public static void main(String[] args) {
//		long id, String name, int age, float salary, int level, int experiance, Gender gender
		Employee emp =new Employee(1,"Fenil",21,20542,2,2,Gender.MALE);
		System.out.println("Employee 1: "+ emp.toString());
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
		public int getExperiance() {
			return experiance;
		}
		public void setExperiance(int experiance) {
			this.experiance = experiance;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		

}
