package arjen.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RekeningServletListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Applicatie is aan het opstarten!");

    }
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("applicatie gaat afsluiten");
        System.out.println("Ruim objecten op, of sla data op");
    }
}
