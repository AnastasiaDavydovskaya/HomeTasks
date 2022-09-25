package by.tms.lesson23and24.task2.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InfoServlet", urlPatterns = {"/course/information"})
public class InfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=cp1251");
        PrintWriter writer = response.getWriter();
        writer.println("<html>" +
                "<body>" +
                "<h2>Запись на курсы</h2>\n" +
                "<hr>\n" +
                "<form action=\"/list/students/result\" method=\"POST\">\n" +
                "    <p>Имя:<br>\n" +
                "        <input type=\"text\" name=\"name\" required>\n" +
                "    </p>\n" +
                "    <p>Язык программирования:<br>\n" +
                "    <input type=\"radio\" name=\"language\" value=\"c++\"> C++<Br>\n" +
                "    <input type=\"radio\" name=\"language\" value=\"php\"> PHP<Br>\n" +
                "    <input type=\"radio\" name=\"language\" value=\"python\"> Python<Br>\n" +
                "    </p>\n" +
                "    <p>Дополнительная информация:<br>\n" +
                "        <textarea rows=\"4\" cols=\"30\" name=\"info\"></textarea>\n" +
                "    </p>\n" +
                "    <p>Секретное слово:<br>\n" +
                "        <input type=\"password\" maxlength=\"25\" size=\"20\" name=\"secretWord\" required>\n" +
                "    </p>\n" +
                "    <p>\n" +
                "        <input type=\"submit\" value=\"Отправить\">\n" +
                "        <input type=\"reset\" value=\"Очистить\">\n" +
                "    </p>\n" +
                "</form>" +
                "</body>" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
