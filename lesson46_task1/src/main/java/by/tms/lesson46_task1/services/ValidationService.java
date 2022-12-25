package by.tms.lesson46_task1.services;

import by.tms.lesson46_task1.entities.Role;
import by.tms.lesson46_task1.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ValidationService {

    private UserService userService;

    public Role validateUser(String email, String password) {
        List<User> users = userService.findUserFromDb();
        for (User user : users) {
            if (user.getLogin().equals(email) && user.getPassword().equals(password)) {
                if (user.getRole().equals(Role.ADMIN)) {
                    return Role.ADMIN;
                } else if (user.getRole().equals(Role.CUSTOMER)) {
                    return Role.CUSTOMER;
                }
            }
        }

        return Role.UNDEFINED;
    }
}
