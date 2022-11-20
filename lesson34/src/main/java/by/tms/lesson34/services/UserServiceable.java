package by.tms.lesson34.services;

import by.tms.lesson34.entities.User;

import java.util.List;

public interface UserServiceable {

    boolean addNewUser(String email, String password);
    List<User> getUsers();
    Long getLastId();
    boolean deleteUser(String login);
    User changeLogin(String parameter, String login);
    User changePassword(String parameter, String password);
    boolean isUniqueLogin(String login);
    boolean isUniquePassword(String password);
}
