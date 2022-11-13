package by.tms.lesson34.services;

import by.tms.lesson34.entities.User;

import java.util.List;

public interface UserServiceable {

    void addNewUser(User user);
    List<User> getUsers();
    Long getLastId();
    void deleteUser(User user);
    User changeLogin(User user, String login, String parameter);
    User changePassword(User user, String password, String parameter);
    boolean isUniqueLogin(String login);
    boolean isUniquePassword(String password);
}
