package assignment;

import java.util.List;
import java.util.Map;

import assignment.Employee.Gender;

public interface EmployeeService {

	double getEmployeebyLevelsTotalSalaries(List<Employee> allEmployee, int level);

	double getEmployeebyGenderTotalSalaries(List<Employee> allEmployee, Gender gender);

	double getEmployeeByNameTotalSalaries(List<Employee> allEmployee, String name);

	double getEmployeeByLevelAndGenderTotalSalaries(List<Employee> allEmployee, int level, Gender gender);

	Map<Gender, List<Employee>> getEmployeeByGender(List<Employee> allEmployee);

}