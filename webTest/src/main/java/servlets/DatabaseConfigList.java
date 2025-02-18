package servlets;

import java.io.InputStream;
import java.util.Properties;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import dao.EmployeeServicesImpl;
import dao.EmployeeSevices;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class DatabaseConfigList implements ServletContextListener {
	EmployeeDAO empdao;
	EmployeeSevices es;
	DeptDAO dep;
		@Override
		public void contextDestroyed(ServletContextEvent sce) {
			// TODO Auto-generated method stub
			ServletContextListener.super.contextDestroyed(sce);
		}
	 
		@Override
		public void contextInitialized(ServletContextEvent sce) {
			ServletContext context = sce.getServletContext();
			Properties properties = new Properties();
			try (InputStream input = DatabaseConfigList.class.getClassLoader().getResourceAsStream("db.properties")) {
	            // Load the properties file into the Properties object
	            if (input == null) {
	                System.out.println("Sorry, unable to find db.properties");
	                return;
	            }
	            properties.load(input);
//	            System.out.println(properties.get);
	            // Retrieve and set database connection properties in ServletContext
	            context.setAttribute("db.url", properties.getProperty("jdbc.url"));
	            context.setAttribute("db.username", properties.getProperty("jdbc.username"));
	            context.setAttribute("db.password", properties.getProperty("jdbc.password"));
	            context.setAttribute("db.driver", properties.getProperty("jdbc.driver"));
	            //System.out.println(properties.getProperty("db.password"));
	            System.out.println("Database connection properties loaded into ServletContext."+context.getAttribute("db.password"));
	            
	            try {
	        			Class.forName((String)context.getAttribute("db.driver"));
	        		} catch (ClassNotFoundException e) {
	        			e.printStackTrace();// TODO: handle exception
	        		}
	            properties.setProperty("user",properties.getProperty("jdbc.username"));
	            properties.setProperty("password", "postgres");
	            empdao=new EmployeeDAOImpl(context,properties);
	            es = new EmployeeServicesImpl(context,properties);
	            dep= new DeptDAOImpl(context,properties);
	            context.setAttribute("emps", empdao);
	            context.setAttribute("es", es);
	            context.setAttribute("dept", dep);
	            
	        	}catch (Exception ex) {
	        		ex.printStackTrace();
	        }
	    }
	
}
