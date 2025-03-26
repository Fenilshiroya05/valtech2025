package spring.aop.revision;

import org.hibernate.Session;

import spring.tx.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Override
	public Employee save(Session ses,Employee e) {
		long id = (long) ses.save(e);
		return (Employee) ses.load(Employee.class, id);
	}
	
	@Override
	public Employee get(Session ses,long id) {
		return (Employee) ses.load(Employee.class, id);
	}
	
	@Override
	public Employee update(Session ses,Employee e) {
		ses.update(e);
		return get(ses,e.getId());
	}
}
