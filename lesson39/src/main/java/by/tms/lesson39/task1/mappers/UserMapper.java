package by.tms.lesson39.task1.mappers;

import by.tms.lesson39.task1.entities.Role;
import by.tms.lesson39.task1.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .id(rs.getLong("id"))
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .role(Role.valueOf(rs.getString("role")))
                .build();
    }
}
