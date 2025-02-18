package servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class LoadConfigListener implements ServletContextListener {

	@Override
    public void contextInitialized(ServletContextEvent sce) {
	System.out.println("First piece of code that will be executed..");
	System.out.println("Loading... Config...... done...");
	System.out.println("Creating Database pools .......");
	ServletContext application = sce.getServletContext();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Closing all Database Connections in the Connection Pools...");
	}
}
