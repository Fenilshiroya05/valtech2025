package dao;

import java.util.List;

import classes.Employee;
import classes.Employee.Gender;


public interface EmployeeDAO {
	
	void save(Employee e);
	void update(Employee e);
	void delete(int id);
	Employee get(int id);
	
	List<Employee> searchByName(String name);
	List<Employee> searchByAge(int age);
	List<Employee> searchByGender(String gender);
	List<Employee> searchBySalary(float salary, String condition);
	List<Employee> searchByLevel(int level);
	List<Employee> searchByExperience(int ex);
	List<Employee> searchById(long id);
	
	
//	List<Employee> findSalaryGreater();
//	List<Employee> findSalaryLess();
//	List<Employee> findSalaryEqual();
	
	List<Employee> getAll();
}
