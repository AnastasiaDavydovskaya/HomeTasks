package by.tms.lesson34.repositories;


import by.tms.lesson34.entities.User;

import java.util.List;

public interface UserControllable extends Controllable {

    void createUser(User user);
    List<User> readUsers();
    void updateUser(User user, String login);
    void deleteUser(User user);
    boolean isUnique(String string, String request, String column);
}
