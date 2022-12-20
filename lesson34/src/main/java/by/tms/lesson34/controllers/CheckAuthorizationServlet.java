package by.tms.lesson34.controllers;

import by.tms.lesson34.entities.Result;
import by.tms.lesson34.entities.Role;
import by.tms.lesson34.entities.User;
import by.tms.lesson34.services.UserService;
import by.tms.lesson34.services.ValidationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckAuthorizationServlet", value = "/enter")
public class CheckAuthorizationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Role role = new ValidationService().validateUser(email, password);
        if (Role.ADMIN.equals(role)) {
            getServletContext().setAttribute("users", new UserService().getUsers());
            getServletContext().getRequestDispatcher("/adminPage.jsp").forward(request, response);
        } else if (Role.CUSTOMER.equals(role)) {
            getServletContext().getRequestDispatcher("/mainPage.jsp").forward(request, response);
        } else {
            getServletContext().setAttribute("result", Result.NOT_FOUND);
            response.sendRedirect("/errorEnter.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
