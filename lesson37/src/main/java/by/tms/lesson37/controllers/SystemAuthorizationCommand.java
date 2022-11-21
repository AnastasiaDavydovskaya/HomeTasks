package by.tms.lesson37.controllers;

import by.tms.lesson37.entities.Result;
import by.tms.lesson37.entities.Role;
import by.tms.lesson37.services.ValidationService;

public class SystemAuthorizationCommand extends FrontCommand {

    @Override
    public void process() {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Role role = new ValidationService().validateUser(email, password);

        if (Role.ADMIN.equals(role)) {
            target("adminPage");
        } else if (Role.CUSTOMER.equals(role)) {
            target("mainPage");
        } else {
            context.setAttribute("result", Result.NOT_FOUND);
            target("errorEnter");
        }
    }
}

