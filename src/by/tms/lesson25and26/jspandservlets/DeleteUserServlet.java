package by.tms.lesson25and26.jspandservlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/delete/user")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("to-delete");
        Map<String, User> users = (Map<String, User>) getServletContext().getAttribute("users");
        PrintWriter writer = response.getWriter();

        User removeUser = users.remove(parameter);
        if (removeUser != null) {
            writer.println("<html>" +
                    "<body>" +
                    "<h1>User was deleted</h1>" +
                    "</body>" +
                    "</html>");
            getServletContext().setAttribute("users", users);
        } else {
            writer.println("<html>" +
                    "<body>" +
                    "<h1>Users not found</h1>" +
                    "</body>" +
                    "</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
