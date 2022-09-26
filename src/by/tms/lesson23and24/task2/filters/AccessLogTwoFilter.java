package by.tms.lesson23and24.task2.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(displayName = "AccessLogTwoFilter", urlPatterns = {"/list/students/result"})
public class AccessLogTwoFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (AccessLogFirstFilter.users.size() == 1) {
            getServletContext().getRequestDispatcher("/authorization").forward(request, response);
        }

        chain.doFilter(request, response);
    }
}
