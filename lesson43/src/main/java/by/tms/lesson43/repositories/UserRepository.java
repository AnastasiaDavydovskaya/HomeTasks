package by.tms.lesson43.repositories;

import by.tms.lesson43.entities.Role;
import by.tms.lesson43.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class UserRepository implements CrudRepository<User> {

    private JdbcTemplate jdbcTemplate;
    private static final String INSERT_USER = "INSERT INTO user (login, password, role) VALUES (?, ?, ?);";
    private static final String DELETE_USER = "DELETE FROM user WHERE id = ?;";
    private static final String UPDATE_USER = "UPDATE user SET login = ?, password = ? WHERE login = ?;";
    private static final String SELECT_USERS = "SELECT * FROM user;";
    private static final String SELECT_USERS_BY_ID = "SELECT * FROM user WHERE id = ?;";
    private static final String SELECT_USER_PASSWORD = "SELECT user.password FROM user;";

    @Override
    public User create(User user) {
        jdbcTemplate.update(INSERT_USER,
                user.getLogin(),
                user.getPassword(),
                Role.CUSTOMER.name());

        return user;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.queryForStream(SELECT_USERS,
                new BeanPropertyRowMapper<>(User.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_USERS_BY_ID,
                new BeanPropertyRowMapper<>(User.class),
                id));
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE_USER, id);
    }
}
