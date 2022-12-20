package by.tms.lesson39.task1.repositories;

import by.tms.lesson39.task1.entities.User;
import by.tms.lesson39.task1.mappers.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Slf4j
@AllArgsConstructor
public class UserRepository {

    private static final String SELECT_USERS = "SELECT * FROM user;";

    private JdbcTemplate jdbcTemplate;

    public List<User> readUsers() {
        Stream<User> stream = jdbcTemplate.queryForStream(SELECT_USERS, new UserMapper());
        return stream.collect(Collectors.toList());
    }

}
