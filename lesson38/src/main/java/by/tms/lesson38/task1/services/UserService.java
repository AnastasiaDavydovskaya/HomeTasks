package by.tms.lesson38.task1.services;

import by.tms.lesson38.task1.entities.User;
import by.tms.lesson38.task1.repositories.UserRepository;
import lombok.Setter;

import java.util.List;

@Setter
public class UserService {

    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.readUsers();
    }

}
