package by.tms.lesson37.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class FrontControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = getCommand(request);
        command.init(getServletContext(), request, response);
        command.process();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private static FrontCommand getCommand(HttpServletRequest request) {
        return switch (request.getServletPath()) {
            case "/enter_system" -> new SystemAuthorizationCommand();
            case "/system_delete" -> new SystemDeleteCommand();
            case "/system_save" -> new SystemSaveCommand();
            case "/system_update" -> new SystemUpdateCommand();
            default -> throw new IllegalStateException("Unexpected value");
        };
    }
}
