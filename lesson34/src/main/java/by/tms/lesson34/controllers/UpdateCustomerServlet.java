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

@WebServlet(name = "UpdateCustomerServlet", urlPatterns = "/list/update")
public class UpdateCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        String originLogin = request.getParameter("to-update");
        String newLogin = request.getParameter("login-to-update");
        String newPassword = request.getParameter("password-to-update");

        UserService userService = new UserService();
        List<User> users = userService.getUsers();
        boolean flag = false;
        for(User user: users) {
            if(user.getLogin().equals(originLogin)) {
                userService.changeLogin(user, newLogin, originLogin);
                userService.changePassword(user, newPassword, originLogin);
                flag = true;
            }
        }

        if (flag) {
            getServletContext().setAttribute("result", Result.SUCCESS_UPDATE);
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
