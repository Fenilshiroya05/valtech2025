
package servlets;

import java.io.IOException;
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

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = (EmployeeDAOImpl) config.getServletContext().getAttribute("emps");
        deptDAO = (DeptDAOImpl) config.getServletContext().getAttribute("dept");
        es = (EmployeeServicesImpl) config.getServletContext().getAttribute("es");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        HttpSession session = req.getSession();
        Dept current = (Dept) session.getAttribute("current");

        if (current == null) {
            current = deptDAO.first();
        }  else if("Last".equals(operation)) {
			current = deptDAO.last();
		}else if("Next".equals(operation)) {
			current = deptDAO.next(current.getId());
			//System.out.println(current);
		}else {
			current = deptDAO.previous(current.getId());
		}

        session.setAttribute("current", current);
        
        session.setAttribute("emps", deptDAO.getEmployeesByDeptId(current.getId())); // Add the employee list to the session
        
        req.setAttribute("dept", current);

        if ("Cancel".equals(operation)) {
            req.setAttribute("emps", deptDAO.getAll());
            req.getRequestDispatcher("depts.jsp").forward(req, resp);
            return;
        }

        Dept depts = Dept.builder()
                .id(Integer.parseInt(req.getParameter("id")))
                .name(req.getParameter("name"))
                .location(req.getParameter("location"))
                .build();

        if ("Save".equals(operation)) {
            deptDAO.save(depts);
        } else if ("Update".equals(operation)) {
            deptDAO.update(depts);
        }

        req.setAttribute("depts", deptDAO.getAll());
        req.getRequestDispatcher("depts.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("operation");
        HttpSession session = req.getSession();
        Dept current = (Dept) session.getAttribute("current");

        if (current == null) {
            current = deptDAO.first();
            session.setAttribute("current", current);
        }

        session.setAttribute("emps", deptDAO.getEmployeesByDeptId(current.getId())); // Add the employee list to the session
        req.setAttribute("dept", current);
        req.setAttribute("depts", deptDAO.getAll());

	   
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

  
        req.getRequestDispatcher("depts.jsp").forward(req, resp);
    }
}

