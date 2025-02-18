package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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

	private Map<Integer,Dept> depts;
	
	public DeptDAOImpl() {
		depts = new HashMap<Integer,Dept>();
	}
	
	public void save(Dept dept) {
		depts.put(dept.getId(),dept);
	}
	public void update(Dept dept) {
		depts.put(dept.getId(), dept);
	}
	public Dept getDept(int id) {
		return depts.get(id);
	}
	public void delete (int id) {
		depts.remove(id);
	}
	public Set<Dept> getAll(){
		Set<Dept> all = new HashSet<Dept>();
		for (int id : depts.keySet()) {
			all.add(depts.get(id));	
		}
		return all;
	}
	
	@Override
	public Dept first() {
		return depts.get(depts.keySet().stream().min((a,b)-> (a-b)).get());
	}
	
	
	@Override
	public Dept last() {
		return depts.get(depts.keySet().stream().max((a,b)-> (a-b)).get());
	}
	
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
	

}
