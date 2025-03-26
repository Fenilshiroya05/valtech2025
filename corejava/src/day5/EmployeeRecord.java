package day5;

import assignment.Employee.Gender;

public record EmployeeRecord(int id,String name,int age,Gender gender,float salary,
		int experiance,int level) {
	
	public EmployeeRecord() {//default constructor
		this(0,"",0,Gender.MALE,0,0,0);
	}
	
	// business methods related to class like employeeHours, employeeBonus etc.
	public int computeBonus() {
		return experiance * 100 + level * 1000;
	}
}
