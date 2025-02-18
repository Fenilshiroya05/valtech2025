package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

	@Test
	void test() {
		System.out.println(Employee.builder().gender("MALE").build());
		
	}

}
