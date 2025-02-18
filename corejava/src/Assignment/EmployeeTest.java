package Assignment;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import Assignment.Employee.Gender;
import Day2.Car;
//import dao.Employee;

class EmployeeTest {
	

	List<Employee> allEmployee = new ArrayList<>();
	
	
	
	 public static String getEmployeebyLevels(int level,List<Employee> allEmployee){ 
		   List<Employee> empByLevels= allEmployee.stream().filter(e-> e.getLevel()==level).collect(Collectors.toList());
		   System.out.println("List By Levels = "+ empByLevels);
		   double emp1= allEmployee.stream().filter(e-> e.getLevel()==level).mapToDouble(Employee::getSalary).sum();
		   if(emp1>0) {
				  return "Total Sum of salary by Level  = "+ emp1;
			  }
			  else 
			  {
				  return level+" not available in DATA";
			  }
	   }
	   
	   public static double getEmployeebyGender(Gender gender,List<Employee> allEmployee) {
		   List<Employee> empByGender= allEmployee.stream().filter(e-> e.getGender().equals(gender)).collect(Collectors.toList());
		   System.out.println("List By Levels = "+ empByGender);
		   return allEmployee.stream().filter(e-> e.getGender().equals(gender)).mapToDouble(Employee::getSalary).sum();
	   }
	   
	  public static String getEmployeeByName(String name,List<Employee> allEmployee) {
		  List<Employee> empByName= allEmployee.stream().filter(e-> e.getName().equals(name)).collect(Collectors.toList());
		  System.out.println("List By Levels = "+ empByName);
		  double emp1=allEmployee.stream().filter(e-> e.getName().equals(name)).mapToDouble(Employee::getSalary).sum();
		  if(emp1>0) {
			  return "Total Sum of salary = "+ emp1;
		  }
		  else 
		  {
			  return name+" not available in DATA";
		  }
		  
	   }
	   public static String getEmployeeByLevelAndGender(int level,Gender gender,List<Employee> allEmployee) {
		   List<Employee> empByName= allEmployee.stream().filter(e-> e.getGender().equals(gender) && e.getLevel()==level) .collect(Collectors.toList());
		   System.out.println("List By Levels = "+ empByName);
		   double emp1=allEmployee.stream().filter(e-> e.getGender().equals(gender) && e.getLevel()==level).mapToDouble(Employee::getSalary).sum();
		   if(emp1>0) {
				  return "Total Sum of salary by Level and Gender = "+ emp1;
			  }
			  else 
			  {
				  return "Not available in DATA";
			  }
	   }
	   
//	   public static List<Employee> searchByNameContents(String name) {
//		  List<Employee> result = allEmployee.stream().filter( emp -> name.contains(emp.getName())).collect(Collectors.toList());
//		  //result.forEach( results -> System.out.println(((Employee) result).getName()));
//		  return result;
//	   }

		
		public static Map<Gender,List<Employee>> getEmployeeByGender(List<Employee> allEmployee) {
			
			return allEmployee.stream().collect(Collectors.groupingBy(e->e.getGender()));
//			getEmployeeMap.put(Gender.MALE, allEmployee.stream().filter(e->e.gender.equals(Gender.MALE)).collect(Collectors.toList()));
//			getEmployeeMap.put(Gender.FEMALE, allEmployee.stream().filter(e->e.gender.equals(Gender.FEMALE)).collect(Collectors.toList()));
//			getEmployeeMap.put(Gender.OTHER, allEmployee.stream().filter(e->e.gender.equals(Gender.OTHER)).collect(Collectors.toList()));
//			return getEmployeeMap;
		}

	
	@Test
	void testHash() {
		Employee emp=Employee.builder().id(1).name("Fenil").age(21).level(3).salary(10000).experience(1).gender("MALE").build();
		Employee e1=Employee.builder().id(1).name("Khushal").age(23).level(2).salary(25000).experience(4).gender("MALE").build();
		Employee e2=Employee.builder().id(1).name("Fenil").age(21).level(3).salary(10000).experience(1).gender("MALE").build();
		assertNotEquals(emp.hashCode(),e1.hashCode());
		assertEquals(emp.hashCode(),e2.hashCode());
	}
	
	@Test
	void testEqulas() {
		Employee emp=Employee.builder().id(1).name("Fenil").age(21).level(3).salary(10000).experience(1).gender("MALE").build();
		Employee e1=Employee.builder().id(1).name("Khushal").age(23).level(2).salary(25000).experience(4).gender("MALE").build();
		Employee e2=Employee.builder().id(1).name("Fenil").age(21).level(3).salary(10000).experience(1).gender("MALE").build();
		assertTrue(emp.equals(e2));
		assertFalse(emp.equals(e1));
	}
	
	
	@Test
	void test() {
		Employee.builder().id(1).name("Fenil").age(21).level(3).salary(10000).experience(1).gender("MALE").build();
		Employee.builder().id(1).name("Khushal").age(23).level(2).salary(25000).experience(4).gender("MALE").build();
		Employee.builder().id(1).name("Rashi").age(19).level(3).salary(56000).experience(2).gender("FEMALE").build();
		Employee.builder().id(1).name("Raj").age(22).level(1).salary(105000).experience(8).gender("MALE").build();
		Employee.builder().id(1).name("Chaitanya").age(35).level(1).salary(431000).experience(5).gender("MALE").build();
		Employee.builder().id(1).name("Marsh").age(42).level(2).salary(11000).experience(8).gender("OTHER").build();
		
		
		System.out.println("---------------------------------- LIST OF ALL EMPLOYEES ----------------------------------");
		
		Collections.sort(Employee.allEmployee);
		for (Employee emps : Employee.allEmployee) {
			System.out.println(emps);
		}
		
		System.out.println("---------------------------------- OUTPUT ----------------------------------");
		
		String emp1= Employee.getEmployeebyLevels(3);
		System.out.println(emp1);
		
		
		System.out.println("----------------------------------OUTPUT----------------------------------");
		
		double emp2= Employee.getEmployeebyGender(Gender.MALE);
		System.out.println("Salary Sum By Gender = " + emp2);
		
		System.out.println("----------------------------------OUTPUT----------------------------------");
		
		String emp3= Employee.getEmployeeByName("Fenil");
		System.out.println(emp3);
		
		System.out.println("----------------------------------OUTPUT----------------------------------");
		
		String emp4= Employee.getEmployeeByLevelAndGender(2,Gender.FEMALE);
		System.out.println(emp4);
		
		System.out.println("----------------------------------OUTPUT----------------------------------");
		
		Map<Gender,List<Employee>> emp5= Employee.getEmployeeByGender();
		System.out.println("All Employee List By Gender  = " + emp5);
		
		System.out.println("----------------------------------OUTPUT----------------------------------");
		
	
	}
}
