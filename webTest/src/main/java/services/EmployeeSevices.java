package services;

import java.util.List;

import classes.Employee;

public interface EmployeeSevices {

	List<Employee> sortByName(List<Employee> e,Boolean a);
	List<Employee> sortById(List<Employee> e,Boolean a);
	List<Employee> sortByGender(List<Employee> e,Boolean a);
	List<Employee> sortBySalary(List<Employee> e,Boolean a);
	List<Employee> sortByExperience(List<Employee> e,Boolean a);
	List<Employee> sortByLevel(List<Employee> e,Boolean a);
	List<Employee> sortByAge(List<Employee> e,Boolean a);
}
