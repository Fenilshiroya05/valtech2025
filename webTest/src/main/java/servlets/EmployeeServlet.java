package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import classes.Employee;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.EmployeeServicesImpl;
import services.EmployeeSevices;

@WebServlet(urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet{
	
	private EmployeeDAO dao;
	private EmployeeSevices es;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		dao= (EmployeeDAOImpl)config.getServletContext().getAttribute("emps");
		//dao=new EmployeeDAOImpl(config.getServletContext());
	    es=(EmployeeSevices)config.getServletContext().getAttribute("es");
	}
	
//	@Override
//	public void init() throws ServletException {
//		dao = new EmployeeDAOImpl();
//		es = new EmployeeServicesImpl();
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		HttpSession hs = req.getSession();
		
		if("getAll".equals(req.getParameter("show"))) {
			List<Employee> emp = dao.getAll();
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		if("sortById".equals(operation)) {
			List<Employee> emp = dao.getAll();
			Boolean b = (Boolean)hs.getAttribute("sortById");
			
			hs.setAttribute("sortById",b==null?true:b==false?true:false);
			req.setAttribute("emps", es.sortById(emp, b));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}

		if("sortByName".equals(operation)) {
			List<Employee> emp = dao.getAll();
			//System.out.println(hs.getAttribute("sortByName"));
			hs.setAttribute("sortByName",(Boolean)hs.getAttribute("sortByName")==null?true:(Boolean)hs.getAttribute("sortByName")==false?true:false);
			//System.out.println(hs.getAttribute(operation));
			req.setAttribute("emps", es.sortByName(emp, (Boolean)hs.getAttribute("sortByName")));
			//System.out.println(es.sortByName(emp, true));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		

		if("sortByGender".equals(operation)) {
			
			List<Employee> emp = dao.getAll();
			hs.setAttribute("sortByGender",(Boolean)hs.getAttribute("sortByGender")==null?true:(Boolean)hs.getAttribute("sortByGender")==false?true:false);
			req.setAttribute("emps", es.sortByGender(emp, (Boolean)hs.getAttribute("sortByGender")));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		if("sortByAge".equals(operation)) {
			
			List<Employee> emp =dao.getAll();
			hs.setAttribute("sortByAge",(Boolean)hs.getAttribute("sortByAge")==null?true:(Boolean)hs.getAttribute("sortByAge")==false?true:false);
			req.setAttribute("emps", es.sortByAge(emp, (Boolean)hs.getAttribute("sortByAge")));

			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		if("sortBySalary".equals(operation)) {
			
			List<Employee> emp = dao.getAll();
			hs.setAttribute("sortBySalary",(Boolean)hs.getAttribute("sortBySalary")==null?true:(Boolean)hs.getAttribute("sortBySalary")==false?true:false);
			req.setAttribute("emps", es.sortBySalary(emp, (Boolean)hs.getAttribute("sortBySalary")));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}

		if("sortByLevel".equals(operation)) {
			
			List<Employee> emp = dao.getAll();
			hs.setAttribute("sortByLevel",(Boolean)hs.getAttribute("sortByLevel")==null?true:(Boolean)hs.getAttribute("sortByLevel")==false?true:false);
			req.setAttribute("emps", es.sortByLevel(emp, (Boolean)hs.getAttribute("sortByLevel")));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}

		if("sortByExperience".equals(operation)) {
			
			List<Employee> emp = dao.getAll();
			hs.setAttribute("sortByExperience",(Boolean)hs.getAttribute("sortByExperience")==null?true:(Boolean)hs.getAttribute("sortByExperience")==false?true:false);
			req.setAttribute("emps", es.sortByExperience(emp, (Boolean)hs.getAttribute("sortByExperience")));
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		
		
		if("search".equals(operation)) {
			
			String searchType = req.getParameter("searchType");
			List<Employee> emp1=new ArrayList<>();
			
			if("name".equals(searchType)) {
				String name = req.getParameter("searchV");
                emp1 = dao.searchByName(name);
			}else if("ID".equals(searchType)) {
				int id = Integer.parseInt(req.getParameter("searchV"));
				emp1=dao.searchById(id);
			}else if("age".equals(searchType)) {
				int age = Integer.parseInt(req.getParameter("searchV"));
				emp1=dao.searchByAge(age);
			}else if("gender".equals(searchType)) {
				String gender = req.getParameter("searchV");
				emp1=dao.searchByGender(gender);
			}else if("salary".equals(searchType)) {
				float salary = Float.parseFloat(req.getParameter("searchV"));
				String condi = req.getParameter("salarySort");
				emp1=dao.searchBySalary(salary,condi);
			}else if("level".equals(searchType)) {
				int level = Integer.parseInt(req.getParameter("searchV"));
				emp1=dao.searchByLevel(level);
			}else if("experience".equals(searchType)) {
				int experience = Integer.parseInt(req.getParameter("searchV"));
				emp1=dao.searchByExperience(experience);
			}else
			{
				emp1=dao.getAll();
			}
			req.setAttribute("emps", emp1);
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		if("Update".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			Employee e = dao.get(id);
			req.setAttribute("emp", e);
			req.setAttribute("mode", "Update");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		
		if("Delete".equals(operation)) {
			int id = Integer.parseInt(req.getParameter("id"));
			dao.delete(id);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		if("new".equals(operation)) {
			req.setAttribute("mode", "Save");
			req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
			return;
		}
		req.setAttribute("emps", dao.getAll());
		req.getRequestDispatcher("employees.jsp").forward(req, resp);	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		
		
		Employee emp=  Employee.builder().id(Integer.parseInt(req.getParameter("id")))
				.name(req.getParameter("name"))
				.age(Integer.parseInt(req.getParameter("age")))
				.gender(req.getParameter("gender").toUpperCase())
				.salary(Integer.parseInt(req.getParameter("salary")))
				.experience(Integer.parseInt(req.getParameter("experience")))
				.level(Integer.parseInt(req.getParameter("level"))).build();
		
		
		if("Cancel".equals(operation)) {
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		
		if("Save".equals(operation)) {
			dao.save(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		if("Update".equals(operation)) {
			dao.update(emp);
			req.setAttribute("emps", dao.getAll());
			req.getRequestDispatcher("employees.jsp").forward(req, resp);
			return;
		}
		
		
		
	}

}
