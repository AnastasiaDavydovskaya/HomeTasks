package by.tms.lesson27and28.lesson27.servlet;

import by.tms.lesson27and28.lesson27.pojo.Role;
import by.tms.lesson27and28.lesson27.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ValidateServlet", value = "/validate")
public class ValidateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        List<User> users = (List<User>) getServletContext().getAttribute("users");

        if (name == null || number == null || number.length() < 12 || name.contains(" ")) {
            response.sendRedirect("/lesson27and28/main/form.jsp");
        } else {
            users.add(new User(name, number, Role.STUDENT));
            getServletContext().setAttribute("users", users);
            getServletContext().getRequestDispatcher("/lesson27and28/main/listUsers.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}