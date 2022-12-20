package by.tms.lesson37.services;

import by.tms.lesson37.entities.Role;
import by.tms.lesson37.entities.User;
import by.tms.lesson37.entities.UserDto;

import java.util.List;

public interface UserServiceable {

    boolean addNewUser(String email, String password);
    List<UserDto> getUsersDto();
    List<User> getUsers();
    boolean deleteUser(String login);
    UserDto changeLogin(String parameter, String login);
    UserDto changePassword(String parameter, String password);
    boolean isUniqueLogin(String login);
    boolean isUniquePassword(String password);
}
