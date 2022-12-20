package by.tms.lesson34.repositories;

import by.tms.lesson34.configs.MySqlConfig;
import by.tms.lesson34.entities.Role;
import by.tms.lesson34.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserControllable {

    private static final String INSERT_USER = "INSERT INTO user (login, password, role) VALUES (?, ?, ?);";
    private static final String DELETE_USER = "DELETE FROM user WHERE login = ?;";
    private static final String UPDATE_USER = "UPDATE user SET login = ?, password = ? WHERE login = ?;";
    private static final String SELECT_USERS = "SELECT * FROM user;";
    private static final String SELECT_LAST_ID_USERS = "SELECT max(id) FROM user;";
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
    public void createUser(User user) {
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
    public List<User> readUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = init()) {
            ResultSet resultSet = connection.prepareStatement(SELECT_USERS).executeQuery();
            while (resultSet.next()) {
                userList.add(new User(
                                resultSet.getLong("id"),
                                resultSet.getString("login"),
                                resultSet.getString("password"),
                                Role.valueOf(resultSet.getString("role"))
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }

    public Long readLastId() {
        Long lastId = null;
        try (Connection connection = init()) {
            ResultSet resultSet = connection.prepareStatement(SELECT_LAST_ID_USERS).executeQuery();
            while (resultSet.next()) {
                lastId = resultSet.getLong("max(id)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lastId;
    }

    @Override
    public void updateUser(User user, String originLogin) {
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
    public void deleteUser(User user) {
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
