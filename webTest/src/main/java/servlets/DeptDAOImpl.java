package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import dao.Employee;
import dao.Employee.Gender;
import jakarta.servlet.ServletContext;

public class DeptDAOImpl implements DeptDAO{
	
	
	
	public DeptDAOImpl(ServletContext sc,Properties p) {
		this.sc=sc;
		this.p=p;
	}
	public DeptDAOImpl(ServletContext sc) {
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
	
	private Connection getConnection() throws SQLException{
		
		//System.out.println(sc.getAttribute("db.password"));
		String pass=(String)sc.getAttribute("db.password");
		System.out.println(pass);
		return DriverManager.getConnection((String)sc.getAttribute("db.url"),(String)sc.getAttribute("db.username"),(String)sc.getAttribute("db.password"));
//		return DriverManager.getConnection((String)sce.getAttribute("db.url"), p);
		
		
//		return DriverManager.getConnection
//				("jdbc:postgresql://localhost:5432/training","postgres","postgres") ;
		
	}

	//private Map<Integer,Dept> depts;
	
	private List<Dept> depts;
	
//	public DeptDAOImpl() {
//		depts = new HashMap<Integer,Dept>();
//	}
//	
//	public void save(Dept dept) {
//		depts.put(dept.getId(),dept);
//	}
//	public void update(Dept dept) {
//		depts.put(dept.getId(), dept);
//	}
//	public Dept getDept(int id) {
//		return depts.get(id);
//	}
//	public void delete (int id) {
//		depts.remove(id);
//	}
//	public Set<Dept> getAll(){
//		Set<Dept> all = new HashSet<Dept>();
//		for (int id : depts.keySet()) {
//			all.add(depts.get(id));	
//		}
//		return all;
//	}
//	@Override
//	public Dept first() {
//		return depts.get(depts.keySet().stream().min((a,b)-> (a-b)).get());
//	}
//	
//	
//	@Override
//	public Dept last() {
//		return depts.get(depts.keySet().stream().max((a,b)-> (a-b)).get());
//	}
	
	
	private Dept populateDept(ResultSet rs) throws SQLException {

		return Dept.builder().id(rs.getInt(1)).name(rs.getString(2)).location(rs.getString(3)).build();
	}
		
		private void setValuesToPreparedStatement(Dept d, PreparedStatement ps) throws SQLException {
			ps.setInt(1, d.getId());
			ps.setString(2, d.getName());
			ps.setString(3, d.getLocation());
		}
	
	@Override
	public List<Dept> getAll() {
		List<Dept> dep = new ArrayList<Dept>();
		
		try(Connection conn = getConnection()) {
			System.out.println("Database Connected");
			PreparedStatement ps = conn.prepareStatement
					("SELECT DEPTID,DEPTNAME,DEPTLOCATION FROM DEPARTMENT");
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				dep.add(populateDept(rs));
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return dep;
		
	}
	
	
	@Override
	public Dept first() {
	    
	    try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT DEPTID,DEPTNAME,DEPTLOCATION FROM DEPARTMENT ORDER BY DEPTID ASC LIMIT 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return populateDept(rs);
			}
			throw new RuntimeException("No departments found");
		} catch (SQLException e) {
			throw new RuntimeException("Error retrieving first department: " + e.getMessage(), e);
		}
	}

	@Override
	public Dept last() {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT DEPTID,DEPTNAME,DEPTLOCATION FROM DEPARTMENT ORDER BY DEPTID DESC LIMIT 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return populateDept(rs);
			}
			throw new RuntimeException("No departments found");
		} catch (SQLException e) {
			throw new RuntimeException("Error retrieving first department: " + e.getMessage(), e);
		}
	}

	@Override
	public Dept next(int id) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT DEPTID,DEPTNAME,DEPTLOCATION FROM DEPARTMENT WHERE DEPTID > ? ORDER BY DEPTID ASC LIMIT 1");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return populateDept(rs);
			}else {
				return getDept(id);
			}
		
		} catch (SQLException e) {
			throw new RuntimeException("Error retrieving next department: " + e.getMessage(), e);
		}
	}
	
	@Override
	public Dept previous(int id) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT DEPTID,DEPTNAME,DEPTLOCATION FROM DEPARTMENT WHERE DEPTID < ? ORDER BY DEPTID DESC LIMIT 1");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return populateDept(rs);
			}
			else {
				return getDept(id);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error retrieving previous department: " + e.getMessage(), e);
		}
		
	}
	
	@Override
	public void save(Dept dept) {
		try (Connection conn = getConnection()) {
			 
			//creating the dynamic statement
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO DEPARTMENT (DEPTID,DEPTNAME,DEPTLOCATION) VALUES (?, ?, ?)");
			setValuesToPreparedStatement(dept, ps);
			// executing the statement
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows inserted = " + rowsAffected);
		} catch (SQLException e) {
			throw new RuntimeException("Error inserting department: " + e.getMessage(), e);
		}
	}
	
	@Override
	public void update(Dept dept) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE DEPARTMENT SET DEPTNAME = ?, DEPTLOCATION = ? WHERE DEPTID = ?");
			setValuesToPreparedStatement(dept, ps);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Updated = " + rowsAffected);
		} catch (SQLException e) {
			throw new RuntimeException("Error updating department: " + e.getMessage(), e);
		}
	}
	
	@Override
	public Dept getDept(int id) {
		try(Connection conn = getConnection()) {
			System.out.println("Database Connected");
			PreparedStatement ps = conn.prepareStatement
					("SELECT DEPTID,DEPTNAME,DEPTLOCATION FROM DEPARTMENT WHERE DEPTID=?");
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			if (rs.next()) {
				Dept dep = populateDept(rs);
				return dep;
			}else {
				new  RuntimeException("No id is there"+ id);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	@Override
	public void delete(int id) {
		try (Connection conn = getConnection()) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM DEPARTMENT WHERE DEPTID = ?");
			ps.setInt(1, id);
			int rowsAffected = ps.executeUpdate();
			System.out.println("Rows Deleted = " + rowsAffected);
		} catch (SQLException e) {
			throw new RuntimeException("Error deleting department: " + e.getMessage(), e);
		}
	}
	
	private Employee populateEmployee(ResultSet rs) throws SQLException {

		return Employee.builder().id(rs.getLong(1)).name(rs.getString(2)).age(rs.getInt(3)).gender(rs.getString(4))
				.salary(rs.getFloat(5)).experience(rs.getInt(6)).level(rs.getInt(7)).dept_id(8).build();
		
	}
	
	@Override
	public List<Employee> getEmployeesByDeptId(int id) {
	    List<Employee> employees = new ArrayList<>();
	    
	    try (Connection conn = getConnection()) {
	        PreparedStatement ps = conn.prepareStatement(
	                "SELECT ID,NAME,AGE,GENDER,SALARY,EXPERIANCE,LEVEL FROM EMPLOYEE WHERE DEPT_ID = ?"
	        );
	        ps.setInt(1, id);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()) {
	        	employees.add(populateEmployee(rs));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return employees;
	}
 

	

}
