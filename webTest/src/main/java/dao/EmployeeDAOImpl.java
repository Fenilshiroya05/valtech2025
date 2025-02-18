package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.Employee.Gender;
import jakarta.servlet.ServletContext;

//ximport org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.RuntimeCryptoException;

//import Assignment.Employee;
//import Assignment.Employee.Gender;

public class EmployeeDAOImpl implements EmployeeDAO {
	//constructor for class
	
	public EmployeeDAOImpl(ServletContext sc,Properties p) {
		this.sc=sc;
		this.p=p;
	}
	public EmployeeDAOImpl(ServletContext sc) {
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
	
//	static {
//		try {
//			Class.forName("org.postgresql.Driver");//static method called without Object
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}	
//	
//	}
	
	private Connection getConnection() throws SQLException{
		
		//System.out.println(sc.getAttribute("db.password"));
		String pass=(String)sc.getAttribute("db.password");
		System.out.println(pass);
		return DriverManager.getConnection((String)sc.getAttribute("db.url"),(String)sc.getAttribute("db.username"),(String)sc.getAttribute("db.password"));
//		return DriverManager.getConnection((String)sce.getAttribute("db.url"), p);
		
		
//		return DriverManager.getConnection
//				("jdbc:postgresql://localhost:5432/training","postgres","postgres") ;
		
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
		ps.setInt(5, e.getExperience());
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
		return;
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
			System.out.println("Database Connected");
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

	@Override
	public List<Employee> searchByName(String name) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE NAME LIKE ?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			System.out.println(name);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				emp.add(populateEmployee(rs));
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public List<Employee> findSalaryGreater() {
//		List<Employee> emp = new ArrayList<Employee>();
//		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE SALARY > 15000";
//		try(Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()) {
//				emp.add(populateEmployee(rs));
//				return emp;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public List<Employee> findSalaryLess() {
//		List<Employee> emp = new ArrayList<Employee>();
//		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE SALARY < 15000";
//		try(Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()) {
//				emp.add(populateEmployee(rs));
//				return emp;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public List<Employee> findSalaryEqual() {
//		List<Employee> emp = new ArrayList<Employee>();
//		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE SALARY = 15000";
//		try(Connection conn = getConnection()){
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()) {
//				emp.add(populateEmployee(rs));
//				return emp;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	@Override
	public List<Employee> searchByAge(int age) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE AGE =?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setInt(1, age);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> searchByGender(String gender) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE GENDER = ?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setString(1, gender);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> searchBySalary(float salary, String condition) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE SALARY " + condition + " ?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setFloat(1, salary);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> searchByLevel(int level) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE LEVEL =?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setInt(1, level);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> searchByExperience(int ex) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE EXPERIANCE =?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setInt(1, ex );
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> searchById(long id) {
		List<Employee> emp = new ArrayList<Employee>();
		String sql = "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE ID =?";
		try(Connection conn = getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(name);
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				emp.add(populateEmployee(rs));
				
			}
			System.out.println("Emps"+emp);
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
