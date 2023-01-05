package by.tms.lesson46_task1.services;


import by.tms.lesson46_task1.dto.UserDto;
import by.tms.lesson46_task1.entities.Role;
import by.tms.lesson46_task1.entities.User;
import by.tms.lesson46_task1.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements CrudService<UserDto> {

    private UserRepository userRepository;

    @Override
    public UserDto create(UserDto userDto) {
        User user = User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .role(Role.CUSTOMER)
                .build();
        userRepository.create(user);

        return userDto;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> UserDto.builder()
                        .login(user.getLogin())
                        .password(user.getPassword())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(user -> UserDto.builder()
                        .login(user.getLogin())
                        .password(user.getPassword())
                        .build())
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .build();
        userRepository.update(user);

        return userDto;
    }

    public List<User> findUserFromDb() {
        return userRepository.findAll();
    }
}
