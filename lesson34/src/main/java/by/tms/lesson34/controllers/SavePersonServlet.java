package by.tms.lesson34.controllers;

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

        if (email.equals("") || password.equals("")) {
            response.sendRedirect("/errorEnter.jsp");
        } else {
            UserService userService = new UserService();
            if(userService.isUniqueLogin(email) && userService.isUniquePassword(password)) {
                new UserService().addNewUser(new User(userService.getLastId() + 1, email, password, Role.CUSTOMER));
            } else {
                response.sendRedirect("/errorEnter.jsp");
            }
            getServletContext().getRequestDispatcher("/mainPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
