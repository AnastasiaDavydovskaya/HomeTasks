package by.tms.lesson44_task1.services;


import by.tms.lesson44_task1.entities.User;
import by.tms.lesson44_task1.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements CrudService<User> {

    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User update(User value) {
        return userRepository.update(value);
    }
}
