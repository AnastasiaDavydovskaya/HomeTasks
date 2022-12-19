package by.tms.lesson44_task1.repositories;

import by.tms.lesson44_task1.entities.Role;
import by.tms.lesson44_task1.entities.User;
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
    private static final String UPDATE_USER = "UPDATE user SET login = ?, password = ? where id=?;";
    private static final String SELECT_USERS = "SELECT * FROM user;";
    private static final String SELECT_USERS_BY_ID = "SELECT * FROM user WHERE id = ?;";

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
    public User findById(Long id) {
        return jdbcTemplate.queryForObject(SELECT_USERS_BY_ID,
                new BeanPropertyRowMapper<>(User.class),
                id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE_USER, id);
    }

    @Override
    public User update(User user) {
        jdbcTemplate.update(UPDATE_USER,
                user.getLogin(),
                user.getPassword(),
                user.getId());
        return user;
    }
}
