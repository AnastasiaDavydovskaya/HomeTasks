package by.tms.lesson38.task1.repositories;

import by.tms.lesson38.task1.entities.Role;
import by.tms.lesson38.task1.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final String SELECT_USERS = "SELECT * FROM user;";

    public Connection init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

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

}
