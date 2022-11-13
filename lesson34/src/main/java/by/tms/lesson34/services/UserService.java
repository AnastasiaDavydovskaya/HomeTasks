package by.tms.lesson34.services;

import by.tms.lesson34.entities.User;
import by.tms.lesson34.repositories.UserRepository;

import java.util.List;

public class UserService implements UserServiceable {

    private UserRepository userRepository = new UserRepository();

    @Override
    public void addNewUser(User user) {
        userRepository.createUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.readUsers();
    }

    public Long getLastId() {
        return userRepository.readLastId();
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }

    @Override
    public User changeLogin(User user, String newLogin, String originLogin) {
        user.setLogin(newLogin);
        userRepository.updateUser(user, originLogin);

        return user;
    }

    @Override
    public User changePassword(User user, String newPassword, String originLogin) {
        user.setPassword(newPassword);
        userRepository.updateUser(user, originLogin);

        return user;
    }

    @Override
    public boolean isUniqueLogin(String login) {
        return userRepository.isUnique(login, "SELECT user.login FROM user;", "login");
    }

    @Override
    public boolean isUniquePassword(String password) {
        return userRepository.isUnique(password, "SELECT user.password FROM user;", "password");
    }
}
