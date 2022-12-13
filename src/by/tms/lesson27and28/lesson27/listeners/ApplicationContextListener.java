package by.tms.lesson27and28.lesson27.listeners;

import by.tms.lesson27and28.lesson27.pojo.Role;
import by.tms.lesson27and28.lesson27.pojo.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class ApplicationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("users", init());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        destroy((List<User>) servletContext.getAttribute("users"));
    }

    private List<User> init() {
        List<User> users = new ArrayList<>();
        users.add(new User("Max", "Pain", Role.TEACHER));
        users.add(new User("Super", "User", Role.ADMIN));
        return users;
    }

    private void destroy(List<User> users) {
        users.clear();
    }
}
