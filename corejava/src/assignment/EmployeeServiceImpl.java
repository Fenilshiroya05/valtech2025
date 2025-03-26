package assignment;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import assignment.Employee.Gender;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public double getEmployeebyLevelsTotalSalaries(List<Employee> allEmployee,int level){ 
		   double emp1= allEmployee.stream().filter(e-> e.getLevel()==level).mapToDouble(Employee::getSalary).sum();
		   
		   if(emp1>0) return  emp1;
		   else 
			 return 0;
	   }
	
	@Override
	public double getEmployeebyGenderTotalSalaries(List<Employee> allEmployee,Gender gender) {
		   List<Employee> empByGender= allEmployee.stream().filter(e-> e.getGender().equals(gender)).collect(Collectors.toList());
		   System.out.println("List By Gender = "+ empByGender);
		   return allEmployee.stream().filter(e-> e.getGender().equals(gender)).mapToDouble(Employee::getSalary).sum();
	   }
	   
	@Override
	public double getEmployeeByNameTotalSalaries(List<Employee> allEmployee,String name) {
		  List<Employee> empByName= allEmployee.stream().filter(e-> e.getName().equals(name)).collect(Collectors.toList());
		  System.out.println("List By Name = "+ empByName);
		  double emp1=allEmployee.stream().filter(e-> e.getName().equals(name)).mapToDouble(Employee::getSalary).sum();
		  
		  if(emp1>0) return  emp1;
		   else 
			 return 0;
		  
	   }
	
	@Override
	public double getEmployeeByLevelAndGenderTotalSalaries(List<Employee> allEmployee,int level,Gender gender) {
		   List<Employee> empByName= allEmployee.stream().filter(e-> e.getGender().equals(gender) && e.getLevel()==level).collect(Collectors.toList());
		   System.out.println("List By Level and Gender = "+ empByName);
		   double emp1=allEmployee.stream().filter(e-> e.getGender().equals(gender) && e.getLevel()==level).mapToDouble(Employee::getSalary).sum();
		   
		   if(emp1>0) return  emp1;
		   else 
			 return 0;
	   }
		
	@Override
	public Map<Gender,List<Employee>> getEmployeeByGender(List<Employee> allEmployee) {
			return allEmployee.stream().collect(Collectors.groupingBy(e->e.getGender()));
		}
}
