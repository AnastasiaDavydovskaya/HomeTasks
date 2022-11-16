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
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DeleteCustomerServlet", urlPatterns = "/delete/customer")
public class DeleteCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("to-delete");
        PrintWriter writer = response.getWriter();

        UserService userService = new UserService();
        List<User> users = userService.getUsers();

        boolean flag = false;
        for(User user: users) {
            if(user.getLogin().equals(login)) {
                userService.deleteUser(user);
                flag = true;
            }
        }

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
