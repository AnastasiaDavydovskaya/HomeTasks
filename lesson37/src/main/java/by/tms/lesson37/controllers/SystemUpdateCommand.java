package by.tms.lesson37.controllers;

import by.tms.lesson37.entities.Result;
import by.tms.lesson37.entities.UserDto;
import by.tms.lesson37.services.UserService;

public class SystemUpdateCommand extends FrontCommand {

    @Override
    public void process() {
        String originLogin = request.getParameter("to-update");
        String newLogin = request.getParameter("login-to-update");
        String newPassword = request.getParameter("password-to-update");

        UserService userService = new UserService();
        UserDto userWithNewLogin = userService.changeLogin(originLogin, newLogin);
        UserDto userWithNewPassword = userService.changePassword(originLogin, newPassword);

        if (userWithNewLogin != null && userWithNewPassword != null) {
            context.setAttribute("result", Result.SUCCESS_UPDATE);
            target("errorEnter");
        } else {
            context.setAttribute("result", Result.NOT_FOUND);
            target("errorEnter");
        }
    }
}
