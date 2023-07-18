package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class testListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("init");
		System.out.println("init");
		System.out.println("init");
		System.out.println("init");
		System.out.println("init");
		
		ServletContext servletContext = sce.getServletContext();
		
		servletContext.setAttribute("whatIsLove", "TWICE");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("dest");
		System.out.println("dest");
		System.out.println("dest");
		System.out.println("dest");
		System.out.println("dest");
	}
}
