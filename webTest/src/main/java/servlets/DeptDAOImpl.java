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
	    if (depts != null && !depts.isEmpty()) {
	        return this.getDept(0); // Get the first element
	    }
	    return null; // Return null if the list is empty
	}

	@Override
	public Dept last() {
	    if (depts != null && !depts.isEmpty()) {
	        return depts.get(depts.size() - 1); // Get the last element
	    }
	    return null; // Return null if the list is empty
	}

	
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
	
	@Override
	public Dept next(int id) {
		if(id==depts.size())  return depts.get(depts.size());
		return depts.get(id+1);
	}
	
	@Override
	public Dept previous(int id) {
		if(id==1) return getDept(1);
		return depts.get(id-1) ;
	}
	@Override
	public void save(Dept dept) {
		
	}
	@Override
	public void update(Dept dept) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
//	@Override
//	public Set<Dept> getAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}
