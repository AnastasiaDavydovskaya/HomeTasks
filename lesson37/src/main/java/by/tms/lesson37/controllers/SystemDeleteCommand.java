package by.tms.lesson37.controllers;

import by.tms.lesson37.entities.Result;
import by.tms.lesson37.services.UserService;

public class SystemDeleteCommand extends FrontCommand {

    @Override
    public void process() {
        String login = request.getParameter("to-delete");

        UserService userService = new UserService();
        boolean flag = userService.deleteUser(login);

        if (flag) {
            context.setAttribute("result", Result.SUCCESS_DELETE);
            target("errorEnter");
        } else {
            context.setAttribute("result", Result.NOT_FOUND);
            target("errorEnter");
        }
    }
}
