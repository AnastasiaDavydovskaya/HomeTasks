package by.tms.lesson39.task1.services;

import by.tms.lesson39.task1.entities.User;
import by.tms.lesson39.task1.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.readUsers();
    }
}
