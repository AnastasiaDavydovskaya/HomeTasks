package by.tms.lesson38.task2.services;

import by.tms.lesson38.task2.entities.User;
import by.tms.lesson38.task2.repositories.UserRepository;
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
