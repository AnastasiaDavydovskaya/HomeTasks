package by.tms.lesson34.services;

import by.tms.lesson34.entities.Result;
import by.tms.lesson34.entities.Role;
import by.tms.lesson34.entities.User;

import java.util.List;

public class ValidationService {

    public Role validateUser(String email, String password) {
        if (email.equals("admin@mail.ru") || password.equals("admin")) {
            return Role.ADMIN;
        } else {
            List<User> users = new UserService().getUsers();
            for (User user : users) {
                if (user.getLogin().equals(email) && user.getPassword().equals(password)) {
                    return Role.CUSTOMER;
                }
            }
            return Role.UNDEFINED;
        }
    }
}
