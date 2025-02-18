package servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import dao.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import dao.EmployeeServicesImpl;
import dao.EmployeeSevices;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns="/depts")
public class DeptServlet extends HttpServlet {
	
	private EmployeeDAO dao;
	private DeptDAO deptDAO;
	private EmployeeSevices es;

//	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		deptDAO = new DeptDAOImpl();
//		es = new EmployeeServicesImpl();
//		dao = new EmployeeDAOImpl();
//
//		}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		dao= (EmployeeDAOImpl)config.getServletContext().getAttribute("emps");
		deptDAO= (DeptDAOImpl)config.getServletContext().getAttribute("dept");
		//dao=new EmployeeDAOImpl(config.getServletContext());
	    es=(EmployeeServicesImpl)config.getServletContext().getAttribute("es");
		deptDAO.save(new Dept(1,"HR","BLR"));
		deptDAO.save(new Dept(2,"HR","Ahm"));
		deptDAO.save(new Dept(3,"Dev","BLR"));
		deptDAO.save(new Dept(4,"Dev","Ahm"));
		System.out.println("Added");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		HttpSession session = req.getSession();
		Dept current = (Dept) session.getAttribute("current");
		//System.out.println(current);
		if(current==null) {
			current = deptDAO.first();
			//System.out.println(current);
		} 
		else {
			if("First".equals(operation)) {
				current = deptDAO.first();
			}else if("Last".equals(operation)) {
				current = deptDAO.last();
			}else if("Next".equals(operation)) {
				
				current = deptDAO.next(current.getId());
				//System.out.println(current);
			}else {
				current = deptDAO.previous(current.getId());
			}
		}
		session.setAttribute("current", current);
		//Expression in JSP can work with objects in session also...
		req.setAttribute("dept", current);
		
		Cookie [] cookies=req.getCookies();
		
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName()+" "+ cookies[i].getValue());
		}
		resp.addCookie(new Cookie("operation",operation));
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Employee> emps = dao.getAll(); 
		System.out.println(emps);// Fetch the employee list from DB or other source
		String operation=req.getParameter("operation");
		HttpSession session = req.getSession();
	   
		if("sortByIdDep".equals(operation)) {
			List<Employee> emp = dao.getAll();
			session.setAttribute("sortByIdDep",(Boolean)session.getAttribute("sortByIdDep")==null?true:(Boolean)session.getAttribute("sortByIdDep")==false?true:false);
			req.setAttribute("emps", es.sortById(emp, (Boolean)session.getAttribute("sortByIdDep")));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		
		if("sortByNameDep".equals(operation)) {
			List<Employee> emp = dao.getAll();
			session.setAttribute("sortByNameDep",(Boolean)session.getAttribute("sortByNameDep")==null?true:(Boolean)session.getAttribute("sortByName")==false?true:false);
			req.setAttribute("emps", es.sortByName(emp, (Boolean)session.getAttribute("sortByNameDep")));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		

		if("sortByGenderDep".equals(operation)) {
			List<Employee> emp = dao.getAll();
			session.setAttribute("sortByGenderDep",(Boolean)session.getAttribute("sortByGenderDep")==null?true:(Boolean)session.getAttribute("sortByGenderDep")==false?true:false);
			req.setAttribute("emps", es.sortByGender(emp, (Boolean)session.getAttribute("sortByGenderDep")));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		
		if("sortByAgeDep".equals(operation)) {
			List<Employee> emp =dao.getAll();
			session.setAttribute("sortByAgeDep",(Boolean)session.getAttribute("sortByAgeDep")==null?true:(Boolean)session.getAttribute("sortByAgeDep")==false?true:false);
			req.setAttribute("emps", es.sortByAge(emp, (Boolean)session.getAttribute("sortByAgeDep")));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
		
		if("sortBySalaryDep".equals(operation)) {
			
			List<Employee> emp = dao.getAll();
			session.setAttribute("sortBySalaryDep",(Boolean)session.getAttribute("sortBySalaryDep")==null?true:(Boolean)session.getAttribute("sortBySalaryDep")==false?true:false);
			req.setAttribute("emps", es.sortBySalary(emp, (Boolean)session.getAttribute("sortBySalaryDep")));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}

		if("sortByLevelDep".equals(operation)) {
			
			List<Employee> emp = dao.getAll();
			session.setAttribute("sortByLevelDep",(Boolean)session.getAttribute("sortByLevelDep")==null?true:(Boolean)session.getAttribute("sortByLevelDep")==false?true:false);
			req.setAttribute("emps", es.sortByLevel(emp, (Boolean)session.getAttribute("sortByLevelDep")));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}

		if("sortByExperienceDep".equals(operation)) {
			
			List<Employee> emp = dao.getAll();
			session.setAttribute("sortByExperienceDep",(Boolean)session.getAttribute("sortByExperienceDep")==null?true:(Boolean)session.getAttribute("sortByExperienceDep")==false?true:false);
			req.setAttribute("emps", es.sortByExperience(emp, (Boolean)session.getAttribute("sortByExperienceDep")));
			req.getRequestDispatcher("depts.jsp").forward(req, resp);
			return;
		}
	    req.setAttribute("emps", emps); // Add the employee list to the request
//	    req.getRequestDispatcher("depts.jsp").forward(req, resp);
		System.out.println("DeptServlet"+deptDAO.first());
		req.setAttribute("dept", deptDAO.first());
		
		session.setAttribute("current", deptDAO.first());
		req.getRequestDispatcher("depts.jsp").forward(req, resp);
		
//		String operation = req.getParameter("operation");
//		if("First".equals(operation))
	}
	
	

}
