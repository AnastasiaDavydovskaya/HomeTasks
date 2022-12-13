package by.tms.lesson27and28.lesson27.servlet;

import by.tms.lesson27and28.lesson27.pojo.Result;
import by.tms.lesson27and28.lesson27.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateUserServlet", urlPatterns = "/list/update/parameters/user")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("to-update");
        String name = request.getParameter("name-to-update");
        String tel = request.getParameter("tel-to-update");

        List<User> users = (List<User>) getServletContext().getAttribute("users");
        boolean flag = true;

        for (User user : users) {
            if (user.getNumber().equals(parameter)) {
                user.setName(name);
                user.setNumber(tel);
                getServletContext().setAttribute("users", users);
                getServletContext().setAttribute("result", Result.SUCCESS_UPDATE);
                flag = false;
                getServletContext().getRequestDispatcher("/lesson27and28/result/result.jsp").forward(request, response);
            }
        }

        if (flag) {
            getServletContext().setAttribute("result", Result.NOT_FOUND);
            getServletContext().getRequestDispatcher("/lesson27and28/result/result.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
