package by.tms.lesson34.services;

import by.tms.lesson34.entities.Role;
import by.tms.lesson34.entities.User;
import by.tms.lesson34.repositories.UserRepository;

import java.util.List;

public class UserService implements UserServiceable {

    private UserRepository userRepository = new UserRepository();

    @Override
    public boolean addNewUser(String email, String password) {
        if (isUniqueLogin(email) && isUniquePassword(password)) {
            userRepository.createUser(new User(getLastId() + 1, email, password, Role.CUSTOMER));
            return true;
        }

        return false;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.readUsers();
    }

    public Long getLastId() {
        return userRepository.readLastId();
    }

    @Override
    public boolean deleteUser(String login) {
        List<User> users = getUsers();

        for (User user : users) {
            if (user.getLogin().equals(login)) {
                userRepository.deleteUser(user);
                return true;
            }
        }

        return false;
    }

    @Override
    public User changeLogin(String originLogin, String newLogin) {
        List<User> users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(originLogin)) {
                user.setLogin(newLogin);
                userRepository.updateUser(user, originLogin);
                return user;
            }
        }

        return null;
    }

    @Override
    public User changePassword(String originLogin, String newPassword) {
        List<User> users = getUsers();
        for (User user : users) {
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
