package day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Assignment.Employee.Gender;

class EmployeeRecordTest {

	@Test
	void test() {
		EmployeeRecord er = new EmployeeRecord(1,"ABC",23,Gender.MALE,12000,5,2);
		assertEquals(1,er.id());
		assertEquals("ABC",er.name());
		assertEquals(23,er.age());
		assertEquals(Gender.MALE,er.gender());
		assertEquals(12000,er.salary());
		assertEquals(5,er.experiance());
		assertEquals(2,er.level());
		System.out.println(er);
		
		EmployeeRecord er1 = new EmployeeRecord(1,"ABC",23,Gender.MALE,12000,5,2);
		
		assertEquals(er.hashCode(),er1.hashCode());// true because both have same contents
		assertEquals(er,er1);// true because both have same contents
		
		EmployeeRecord er2 = new EmployeeRecord(1,"BBC",23,Gender.MALE,12000,5,2);
		
		assertFalse(er1.hashCode()==er2.hashCode());//because both have different contents
		assertNotEquals(er1,er2);//true because both are not same
		
		assertEquals(2500,er.computeBonus());
	}

}
