package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import assignment.Employee;
import assignment.Employee.Gender;


class EmployeeDAOTest {

	@Test
	void testInsert() {
		EmployeeDAO dao =new EmployeeDAOImpl();
		//dao.save(new Employee(1,"ABC",22,45000,5,2,Gender.FEMALE));
		//dao.save(new Employee(2,"Working",25,3,42000,5,Gender.FEMALE));
		
		//long id, String name, int age, float salary, int level, int experiance, Gender gender
		Employee e= new Employee(2,"WFH",25,22000,4,6,Gender.MALE);
//		dao.update(e);
//		assertEquals(2,e.getId());
//		assertEquals("W",e.getName());
//		assertEquals(25,e.getAge());
//		assertEquals(4,e.getLevel());
//		assertEquals(22000,e.getSalary());
//		assertEquals(6,e.getExperiance());
//		//assertEquals(Gender.MALE,e.getGender());
//		
		assertTrue(dao.getAll().size()>=1);
		//dao.delete(1);
		
		
		
	}

}
