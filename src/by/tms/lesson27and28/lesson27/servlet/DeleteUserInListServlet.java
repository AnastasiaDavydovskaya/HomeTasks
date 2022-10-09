package by.tms.lesson27and28.lesson27.servlet;

import by.tms.lesson27and28.lesson27.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DeleteUserInListServlet", urlPatterns = "/list/delete/user")
public class DeleteUserInListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("to-delete");
        List<User> users = (List<User>) getServletContext().getAttribute("users");
        PrintWriter writer = response.getWriter();
        int initialSize = users.size();

        for (User user : users) {
            if (user.getNumber().equals(parameter)) {
                users.remove(user);
                getServletContext().setAttribute("users", users);
                getServletContext().getRequestDispatcher("/lesson27and28/result/successfulRemoval.jsp").forward(request, response);
            }
        }

        if(users.size() == initialSize) {
            getServletContext().getRequestDispatcher("/lesson27and28/result/notFoundUser.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
