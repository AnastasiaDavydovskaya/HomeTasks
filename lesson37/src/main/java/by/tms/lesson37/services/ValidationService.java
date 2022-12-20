package by.tms.lesson37.services;

import by.tms.lesson37.entities.Role;
import by.tms.lesson37.entities.User;

import java.util.List;

public class ValidationService {

    public Role validateUser(String email, String password) {
        List<User> users = new UserService().getUsers();
        for (User user : users) {
            if (user.getLogin().equals(email) && user.getPassword().equals(password)) {
                if(user.getRole().equals(Role.ADMIN)) {
                    return Role.ADMIN;
                } else if (user.getRole().equals(Role.CUSTOMER)) {
                    return Role.CUSTOMER;
                }
            }
        }

        return Role.UNDEFINED;
    }
}
