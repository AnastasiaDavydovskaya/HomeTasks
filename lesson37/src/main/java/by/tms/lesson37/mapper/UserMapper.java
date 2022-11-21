package by.tms.lesson37.mapper;

import by.tms.lesson37.entities.Role;
import by.tms.lesson37.entities.User;
import by.tms.lesson37.entities.UserDto;
import by.tms.lesson37.services.UserService;

public class UserMapper {

    public static User toUser(UserDto userDto) {
        return  User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .role(Role.CUSTOMER)
                .build();
    }
}
