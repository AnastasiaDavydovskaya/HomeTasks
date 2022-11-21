package by.tms.lesson37.services;

import by.tms.lesson37.entities.Role;
import by.tms.lesson37.entities.UserDto;

import java.util.List;

public class ValidationService {

    public Role validateUser(String email, String password) {
        if (email.equals("admin@mail.ru") || password.equals("admin")) {
            return Role.ADMIN;
        } else {
            List<UserDto> users = new UserService().getUsersDto();
            for (UserDto user : users) {
                if (user.getLogin().equals(email) && user.getPassword().equals(password)) {
                    return Role.CUSTOMER;
                }
            }
            return Role.UNDEFINED;
        }
    }
}
