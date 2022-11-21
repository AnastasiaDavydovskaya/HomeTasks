package by.tms.lesson37.repositories;

import by.tms.lesson37.entities.Role;
import by.tms.lesson37.entities.User;
import by.tms.lesson37.entities.UserDto;

import java.util.List;

public interface UserControllable extends Controllable {

    void createUser(UserDto userDto);
    List<UserDto> readUsersDto();
    List<User> readUsers();
    void updateUser(UserDto userDto, String login);
    void deleteUser(UserDto userDto);
    boolean isUniqueLogin(String login);
    boolean isUniquePassword(String password);
}
