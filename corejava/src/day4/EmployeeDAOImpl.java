package day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.RuntimeCryptoException;

import Assignment.Employee;
import Assignment.Employee.Gender;

public class EmployeeDAOImpl implements EmployeeDAO {
	//constructor for class
	
	static {
		try {
			Class.forName("org.postgresql.Driver");//static method called without Object
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	
	}
	
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection
				("jdbc:postgresql://localhost:5432/training","postgres","postgres") ;
		
	}

	//public EmployeeDAOImpl() {}

	@Override
	public void save(Employee e) {
		try(Connection conn = getConnection()){
			PreparedStatement ps=conn.prepareStatement
					("INSERT INTO EMPLOYEE(NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL,ID) VALUES (?,?,?,?,?,?,?)");
			setValuesToPreparedStatement(e, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Inserted = "+ rowsAffected);
			
		}catch (Exception e2) {
			throw new RuntimeException(e2);
		}
	}

	private void setValuesToPreparedStatement(Employee e, PreparedStatement ps) throws SQLException {
		ps.setString(1, e.getName());
		ps.setInt(2, e.getAge());
		ps.setString(3, e.getGender().name());
		ps.setDouble(4, e.getSalary());
		ps.setInt(5, e.getExperiance());
		ps.setInt(6, e.getLevel());
		ps.setLong(7,e.getId());
	}

	@Override
	public void update(Employee e) {
		
		try (Connection conn = getConnection()){
			PreparedStatement ps=conn.prepareStatement
					("UPDATE EMPLOYEE SET NAME = ?, AGE = ?, GENDER = ?, SALARY = ?, EXPERIANCE = ?, LEVEL = ? WHERE ID = ?");
			setValuesToPreparedStatement(e, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated = " + rowsAffected);
		} catch (Exception e2) {
			throw new RuntimeException(e2);
		}
		
	}

	@Override
	public void delete(int id) {
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement
					("DELETE FROM EMPLOYEE WHERE ID = ? ");
			ps.setInt(1,id);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Deleted = " + rowsAffected);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Employee get(int id) {
		try (Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement
					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE ID = ?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) { // if this next return true   then we have another row. if next false, we are at end the resultset
				Employee e = populateEmployee(rs);
				return e;
			}else {
				new RuntimeException("No Employee with ID "+ id+" Found.");
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
		
	}

	private Employee populateEmployee(ResultSet rs) throws SQLException {
		
		return Employee.builder().id(rs.getLong(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(rs.getString(4))
				.salary(rs.getFloat(5)).experience(rs.getInt(6)).level(rs.getInt(7)).build();
		
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> emp = new ArrayList<Employee>();
		
		try(Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement
					("SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE");
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				emp.add(populateEmployee(rs));
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return emp;
		
	}

	public static void main(String[] args) {
		
	}

}
