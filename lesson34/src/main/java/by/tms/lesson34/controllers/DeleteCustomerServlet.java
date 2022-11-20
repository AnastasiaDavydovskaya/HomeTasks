package by.tms.lesson34.controllers;

import by.tms.lesson34.entities.Result;
import by.tms.lesson34.entities.User;
import by.tms.lesson34.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteCustomerServlet", urlPatterns = "/delete/customer")
public class DeleteCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("to-delete");

        UserService userService = new UserService();
        boolean flag = userService.deleteUser(login);

        if (flag) {
            getServletContext().setAttribute("result", Result.SUCCESS_DELETE);
            getServletContext().getRequestDispatcher("/errorEnter.jsp").forward(request, response);
        } else {
            getServletContext().setAttribute("result", Result.NOT_FOUND);
            getServletContext().getRequestDispatcher("/errorEnter.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
