package by.tms.lesson34.controllers;

import by.tms.lesson34.entities.Result;
import by.tms.lesson34.entities.Role;
import by.tms.lesson34.entities.User;
import by.tms.lesson34.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SavePersonServlet", value = "/save/person")
public class SavePersonServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean flag = new UserService().addNewUser(email, password);

        if (flag) {
            getServletContext().setAttribute("result", Result.SUCCESS_SAVE);
            response.sendRedirect("/errorEnter.jsp");
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
