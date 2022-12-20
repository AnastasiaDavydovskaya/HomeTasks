package by.tms.lesson37.controllers;

import by.tms.lesson37.entities.Result;
import by.tms.lesson37.services.UserService;

public class SystemSaveCommand extends FrontCommand {

    @Override
    public void process() {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean flag = new UserService().addNewUser(email, password);

        if (flag) {
            context.setAttribute("result", Result.SUCCESS_SAVE);
            target("errorEnter");
        } else {
            context.setAttribute("result", Result.NOT_FOUND);
            target("errorEnter");
        }
    }
}
