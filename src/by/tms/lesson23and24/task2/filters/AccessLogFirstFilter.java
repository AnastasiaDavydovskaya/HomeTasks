package by.tms.lesson23and24.task2.filters;

import by.tms.lesson23and24.task2.servlets.InfoServlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(displayName = "AccessLogFilter", urlPatterns = {"/course/information", "/list/students/result"})
public class AccessLogFirstFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (new String(request.getRequestURL()).equals("/course/information")) {
            String addressInput = request.getParameter("addressInput");
            String passwordInput = request.getParameter("passwordInput");
            String addressRegistration = request.getParameter("addressRegistration");
            String passwordRegistration = request.getParameter("passwordRegistration");

            if ((addressRegistration == null && passwordRegistration == null) && (addressInput == null && passwordInput == null)) {
                getServletContext().getRequestDispatcher("/authorization").forward(request, response);
            }
        } else {
            if (InfoServlet.users.isEmpty()) {
                getServletContext().getRequestDispatcher("/authorization").forward(request, response);
            }
        }

        chain.doFilter(request, response);
    }
}
