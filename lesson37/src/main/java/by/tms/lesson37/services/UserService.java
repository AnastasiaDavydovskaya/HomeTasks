package by.tms.lesson37.services;

import by.tms.lesson37.entities.Role;
import by.tms.lesson37.entities.User;
import by.tms.lesson37.entities.UserDto;
import by.tms.lesson37.repositories.UserRepository;

import java.util.List;

public class UserService implements UserServiceable {

    private UserRepository userRepository = new UserRepository();

    @Override
    public boolean addNewUser(String email, String password) {
        if (isUniqueLogin(email) && isUniquePassword(password)) {
            userRepository.createUser(new UserDto(email, password));
            return true;
        }

        return false;
    }

    @Override
    public List<UserDto> getUsersDto() {
        return userRepository.readUsersDto();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.readUsers();
    }

    @Override
    public boolean deleteUser(String login) {
        List<UserDto> users = getUsersDto();

        for (UserDto user : users) {
            if (user.getLogin().equals(login)) {
                userRepository.deleteUser(user);
                return true;
            }
        }

        return false;
    }

    @Override
    public UserDto changeLogin(String originLogin, String newLogin) {
        List<UserDto> users = getUsersDto();
        for (UserDto user : users) {
            if (user.getLogin().equals(originLogin)) {
                user.setLogin(newLogin);
                userRepository.updateUser(user, originLogin);
                return user;
            }
        }

        return null;
    }

    @Override
    public UserDto changePassword(String originLogin, String newPassword) {
        List<UserDto> users = getUsersDto();
        for (UserDto user : users) {
            if (user.getLogin().equals(originLogin)) {
                user.setPassword(newPassword);
                userRepository.updateUser(user, originLogin);
                return user;
            }
        }

        return null;
    }

    @Override
    public boolean isUniqueLogin(String login) {
        return userRepository.isUniqueLogin(login);
    }

    @Override
    public boolean isUniquePassword(String password) {
        return userRepository.isUniquePassword(password);
    }
}
