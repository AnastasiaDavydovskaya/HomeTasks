package by.tms.lesson34.controllers;

import by.tms.lesson34.entities.User;
import by.tms.lesson34.services.UserService;

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

        if (email.equals("") || password.equals("")) {
            response.sendRedirect("/errorEnter.jsp");
        } else if (email.equals("admin@mail.ru") || password.equals("admin")) {
            getServletContext().getRequestDispatcher("/adminPage.jsp").forward(request, response);
        } else {
            List<User> users = new UserService().getUsers();
            for(User user : users) {
                if(user.getLogin().equals(email) && user.getPassword().equals(password)) {
                    getServletContext().getRequestDispatcher("/mainPage.jsp").forward(request, response);
                }
            }
            response.sendRedirect("/errorEnter.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
