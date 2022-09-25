package by.tms.lesson23and24.task2.filters;

import by.tms.lesson23and24.task2.entities.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(displayName = "AccessLogFilter", urlPatterns = {"/course/information"})
public class AccessLogFirstFilter extends HttpFilter {
    public static List<User> users = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        users.add(new User("user@mail.ru", "user"));
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String addressInput = request.getParameter("addressInput");
        String passwordInput = request.getParameter("passwordInput");
        String addressRegistration = request.getParameter("addressRegistration");
        String passwordRegistration = request.getParameter("passwordRegistration");

        if (addressRegistration != null && passwordRegistration != null) {
            users.add(new User(addressRegistration, passwordRegistration));
        } else if (addressInput != null && passwordInput != null) {
            for (User user : users) {
                if (!user.equals(new User(addressInput, passwordInput))) {
                    getServletContext().getRequestDispatcher("/authorization/error").forward(request, response);
                }
            }
        } else {
            getServletContext().getRequestDispatcher("/authorization").forward(request, response);
        }

        chain.doFilter(request, response);
    }
}
