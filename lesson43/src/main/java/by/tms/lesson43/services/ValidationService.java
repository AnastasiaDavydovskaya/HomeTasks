package by.tms.lesson43.services;

import by.tms.lesson43.entities.Role;
import by.tms.lesson43.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ValidationService {

    private UserService userService;

    public Role validateUser(String login, String password) {
        if (login.equals("admin@mail.ru") && password.equals("admin")) {
            return Role.ADMIN;
        } else {
            List<User> users = userService.findAll();
            for (User user : users) {
                if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    return Role.CUSTOMER;
                }
            }
            return Role.UNDEFINED;
        }
    }
}
