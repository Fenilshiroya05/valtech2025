package dao;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import jakarta.servlet.ServletContext;

public class EmployeeServicesImpl implements EmployeeSevices {
	
	public EmployeeServicesImpl(ServletContext sc,Properties p) {
		this.sc=sc;
		this.p=p;
	}
	public EmployeeServicesImpl(ServletContext sc) {
		this.sc=sc;
	}
	
	private ServletContext sc;
	private Properties p;
	
	public ServletContext getSc() {
		return sc;
	}
	
	public void setSc(ServletContext sc) {
		this.sc = sc;
	}

	
	public List<Employee> sortByName(List<Employee> e,Boolean a) {
	
		if(a) {
		return e.stream().sorted((o1,o2) ->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		}
		else
		{
			return e.stream().sorted((o1,o2) ->o2.getName().compareTo(o1.getName())).collect(Collectors.toList());	
		}
	}

	
	public List<Employee> sortById(List<Employee> e,Boolean a) {
		if(a) {
			return e.stream().sorted((o1,o2) ->Long.compare(o1.getId(), o2.getId())).collect(Collectors.toList());
			}
			else
			{
				return e.stream().sorted((o1,o2) ->Long.compare(o2.getId(), o1.getId())).collect(Collectors.toList());	
			}
	}

	
	public List<Employee> sortByGender(List<Employee> e,Boolean a) {
		if(a ) {
			return e.stream().sorted((o1,o2) ->o1.getGender().compareTo(o2.getGender())).collect(Collectors.toList());
			}
			else
			{
				return e.stream().sorted((o1,o2) ->o2.getGender().compareTo(o1.getGender())).collect(Collectors.toList());	
			}
	}

	public List<Employee> sortByAge(List<Employee> e,Boolean a) {
		if(a) {
			return e.stream().sorted((o1,o2) ->Integer.compare(o1.getAge(), o2.getAge())).collect(Collectors.toList());
			}
			else
			{
				return e.stream().sorted((o1,o2) ->Integer.compare(o2.getAge(), o1.getAge())).collect(Collectors.toList());	
			}
	}
	
	public List<Employee> sortBySalary(List<Employee> e,Boolean a) {
		if(a) {
			return e.stream().sorted((o1,o2) ->Float.compare(o1.getSalary(), o2.getSalary())).collect(Collectors.toList());
			}
			else
			{
				return e.stream().sorted((o1,o2) ->Float.compare(o2.getSalary(), o1.getSalary())).collect(Collectors.toList());	
			}
	}


	public List<Employee> sortByExperience(List<Employee> e,Boolean a) {
		if(a) {
			return e.stream().sorted((o1,o2) ->Integer.compare(o1.getExperience(), o2.getExperience())).collect(Collectors.toList());
			}
			else
			{
				return e.stream().sorted((o1,o2) ->Integer.compare(o2.getExperience(), o1.getExperience())).collect(Collectors.toList());	
			}
	}

	
	public List<Employee> sortByLevel(List<Employee> e,Boolean a) {
		if(a) {
			return e.stream().sorted((o1,o2) ->Integer.compare(o1.getLevel(), o2.getLevel())).collect(Collectors.toList());
			}
			else
			{
				return e.stream().sorted((o1,o2) ->Integer.compare(o2.getLevel(), o1.getLevel())).collect(Collectors.toList());	
			}
	}
}
