package by.tms.lesson37.repositories;

import by.tms.lesson37.configs.MySqlConfig;
import by.tms.lesson37.entities.Role;
import by.tms.lesson37.entities.User;
import by.tms.lesson37.entities.UserDto;
import by.tms.lesson37.mapper.UserMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserControllable {

    private static final String INSERT_USER = "INSERT INTO user (login, password, role) VALUES (?, ?, ?);";
    private static final String DELETE_USER = "DELETE FROM user WHERE login = ?;";
    private static final String DELETE_ROLE = "DELETE FROM user WHERE role = ?;";
    private static final String UPDATE_USER = "UPDATE user SET login = ?, password = ? WHERE login = ?;";
    private static final String SELECT_USERS = "SELECT * FROM user;";
    private static final String SELECT_USER_LOGIN = "SELECT user.login FROM user;";
    private static final String SELECT_USER_PASSWORD = "SELECT user.password FROM user;";


    @Override
    public Connection init() {
        try {
            return MySqlConfig.createConnectionWithDatabase();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = UserMapper.toUser(userDto);
        try (Connection connection = init()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, String.valueOf(user.getRole()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDto> readUsersDto() {
        List<UserDto> userList = new ArrayList<>();
        try (Connection connection = init()) {
            ResultSet resultSet = connection.prepareStatement(SELECT_USERS).executeQuery();
            while (resultSet.next()) {
                userList.add(new UserDto(
                                resultSet.getString("login"),
                                resultSet.getString("password"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    @Override
    public List<User> readUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = init()) {
            ResultSet resultSet = connection.prepareStatement(SELECT_USERS).executeQuery();
            while (resultSet.next()) {
                userList.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        Role.valueOf(resultSet.getString("role")))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    @Override
    public void updateUser(UserDto user, String originLogin) {
        try (Connection connection = init()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, originLogin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(UserDto user) {
        try (Connection connection = init()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isUniqueLogin(String login) {
        return isUnique(login, SELECT_USER_LOGIN, "login");
    }

    @Override
    public boolean isUniquePassword(String password) {
        return isUnique(password, SELECT_USER_PASSWORD, "password");
    }

    private boolean isUnique(String string, String request, String column) {
        try (Connection connection = init()) {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (string.equals(resultSet.getString(column))) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
