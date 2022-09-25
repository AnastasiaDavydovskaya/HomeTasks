package by.tms.lesson23and24.task2.servlets;

import by.tms.lesson23and24.task2.entities.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ResultServlet", urlPatterns = {"/list/students/result"})
public class ResultServlet extends HttpServlet {

    public static List<Student> students = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=cp1251");
        PrintWriter writer = response.getWriter();
        students.add(new Student(request.getParameter("name"),
                request.getParameter("language"),
                request.getParameter("info"),
                request.getParameter("secretWord")));

        writer.println(String.format("<html><h3>Студенты:</h3>" +
                students.toString() +
                "<h4>Перейти на <a href=\"/authorization\">главную страницу</a></h4>" +
                "</html>"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
