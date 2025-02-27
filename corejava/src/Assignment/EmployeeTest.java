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

class EmployeeTest {
	
	@Test
	void testHash() {
		assertNotEquals(Employee.builder().id(1).name("Fenil").age(21).level(3).salary(10000).experience(1).gender("MALE").build().hashCode()
				,Employee.builder().id(1).name("Khushal").age(23).level(2).salary(25000).experience(4).gender("MALE").build().hashCode());
		assertEquals(Employee.builder().id(1).name("Fenil").age(21).level(3).salary(10000).experience(1).gender("MALE").build().hashCode()
				,Employee.builder().id(1).name("Fenil").age(21).level(3).salary(10000).experience(1).gender("MALE").build().hashCode());
	}
	
	@Test
	void testEqulas() {
		
		assertTrue(Employee.builder().id(1).name("Fenil").age(21).level(3).salary(10000).experience(1).gender("MALE").build()
				.equals(Employee.builder().id(1).name("Fenil").age(21).level(3).salary(10000).experience(1).gender("MALE").build()));
		assertFalse(Employee.builder().id(1).name("Fenil").age(21).level(3).salary(10000).experience(1).gender("MALE").build()
				.equals(Employee.builder().id(2).name("Khushal").age(23).level(2).salary(25000).experience(4).gender("MALE").build()));
	}
	
	
	@Test
	void test() {
		Employee.builder().id(1).name("Fenil").age(21).level(3).salary(10000).experience(1).gender("MALE").build();
		Employee.builder().id(2).name("Khushal").age(23).level(2).salary(25000).experience(4).gender("MALE").build();
		Employee.builder().id(3).name("Rashi").age(19).level(3).salary(56000).experience(2).gender("FEMALE").build();
		Employee.builder().id(4).name("Raj").age(22).level(1).salary(10000).experience(8).gender("MALE").build();
		Employee.builder().id(5).name("Chaitanya").age(35).level(1).salary(43000).experience(5).gender("MALE").build();
		Employee.builder().id(6).name("Marsh").age(42).level(2).salary(11000).experience(8).gender("OTHER").build();
		Employee.builder().id(7).name("XYZ").age(24).level(2).salary(15000).experience(6).gender("FEMALE").build();
		
		Collections.sort(Employee.allEmployee);
		int i=1;
		for (Employee emps : Employee.allEmployee) {
			System.out.println("Employee : " +i+" "+emps);
			i++;
			
		}
		
		double emp1= Employee.getEmployeebyLevelsTotalSalaries(3);
		assertEquals(96000.0, emp1);
		System.out.println("Salary Sum By Level ="+emp1);
		
		double emp2= Employee.getEmployeebyGenderTotalSalaries(Gender.MALE);
		assertEquals(143000.0, emp2);
		System.out.println("Salary Sum By Gender = " + emp2);
		
		double emp3= Employee.getEmployeeByNameTotalSalaries("Fenil");
		assertEquals(40000.0, emp3);
		System.out.println("Total Sum of salary = "+emp3);
		
		double emp4= Employee.getEmployeeByLevelAndGenderTotalSalaries(2,Gender.FEMALE);
		assertEquals(15000.0, emp4);
		System.out.println("Total Sum of salary by Level and Gender = "+emp4);
		
		Map<Gender,List<Employee>> emp5= Employee.getEmployeeByGender();
		System.out.println("All Employee List By Gender  = " + emp5);	
	}
}
