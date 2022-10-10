package by.tms.lesson25and26.jspandservlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CheckServlet", value = "/check")
public class CheckServlet extends HttpServlet {

    public static Map<String, User> users = new HashMap();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String number = request.getParameter("number");

        if (name == null || number == null || number.length() < 12 || name.contains(" ")) {
            response.sendRedirect("/jsp/save.jsp");
        } else {
            User user = new User(name, number);
            users.put(number, user);
            getServletContext().setAttribute("users", users);
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/jsp/data.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}