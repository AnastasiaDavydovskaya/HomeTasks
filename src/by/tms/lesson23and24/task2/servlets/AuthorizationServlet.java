package by.tms.lesson23and24.task2.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AuthorizationServlet", urlPatterns = {"/authorization"})
public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=cp1251");
        PrintWriter writer = response.getWriter();
        writer.println("<html>" +
                "<head>" +
                "<style>" +
                ".tabs {position: relative;}" +
                ".tab, .tab-title { display: inline-block;}" +
                ".tab input[type=\"radio\"] { display: none; }" +
                ".tab-title {background: #ccc;padding: 5px 10px;border: 1px solid #666;border-bottom: none;}" +
                ".tab-content {position: absolute;border: 1px solid #666;padding: 10px;left: 0;width: calc(100% - 20px);display: none;}" +
                ".tab :checked + .tab-title {position: relative;background: #fff;top: 1px;z-index: 1;}" +
                ".tab :checked ~ .tab-content {display: block;});" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class=\"tabs\">" +
                "<div class=\"tab\">" +
                "<input type = \"radio\" id = \"tab1\" name = \"tab-group\" checked>" +
                "<label for=\"tab1\" class=\"tab-title\"> Войти </label>" +
                "<section class=\"tab-content\">" +
                "<form action = \"/course/information\" method = \"POST\">" +
                "<p> Адрес электронной почты:<br>" +
                "<input type = \"text\" name = \"addressInput\" required>" +
                "</p>" +
                "<p> Пароль:<br>" +
                "<input type = \"password\" maxlength = \"25\" size = \"20\" name = \"passwordInput\" required>" +
                "</p>" +
                "<input type = \"submit\" value = \"Войти\" style = \"background: cadetblue\">" +
                "</form>" +
                "</section>" +
                "</div>" +
                "<div class=\"tab\">" +
                "<input type = \"radio\" id = \"tab2\" name = \"tab-group\" checked>" +
                "<label for=\"tab2\" class=\"tab-title\"> Зарегистрироваться </label>" +
                "<section class=\"tab-content\">" +
                "<form action = \"/course/information\" method = \"POST\">" +
                "<p> Адрес электронной почты:<br>" +
                "<input type = \"text\" name = \"addressRegistration\" required>" +
                "</p>" +
                "<p> Пароль:<br>" +
                "<input type = \"password\" maxlength = \"25\" size = \"20\" name = \"passwordRegistration\" required>" +
                "</p>" +
                "<p><input id = \"checkbox - 2\" type = \"checkbox\">" +
                "<label for=\"checkbox - 2\" > Я хочу получать рассылку с эксклюзивными предложениями.</label>" +
                "</p>" +
                "<input type = \"submit\" value = \"Создать профиль\" style = \"background: cadetblue\">" +
                "</form>" +
                "</section>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>");
    }
}
