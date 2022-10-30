package by.tms.lesson33;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class Main {

    private static final String INSERT_STUDENT = "INSERT INTO student (first_name, last_name, gpa, city_id) VALUES (?, ?, ?, ?);";
    private static final String DELETE_STUDENT = "DELETE FROM student WHERE first_name = 'Elena';";
    private static final String INSERT_CITY = "INSERT INTO city (street, number) VALUES (?, ?);";
    private static final String DELETE_CITY = "DELETE FROM city WHERE street = 'Popova';";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/students";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatementForCity = connection.prepareStatement(INSERT_CITY);
            preparedStatementForCity.setString(1, "Lenin");
            preparedStatementForCity.setInt(2, 50);
            preparedStatementForCity.executeUpdate();

            preparedStatementForCity.setString(1, "Lobanka");
            preparedStatementForCity.setInt(2, 70);
            preparedStatementForCity.executeUpdate();

            preparedStatementForCity.setString(1, "Popova");
            preparedStatementForCity.setInt(2, 120);
            preparedStatementForCity.executeUpdate();

            PreparedStatement preparedStatementForStudent = connection.prepareStatement(INSERT_STUDENT);
            preparedStatementForStudent.setString(1, "Nastya");
            preparedStatementForStudent.setString(2, "Davydovskaya");
            preparedStatementForStudent.setFloat(3, 8.6F);
            preparedStatementForStudent.setFloat(4, 1);
            preparedStatementForStudent.executeUpdate();

            preparedStatementForStudent.setString(1, "Elena");
            preparedStatementForStudent.setString(2, "Davydovskaya");
            preparedStatementForStudent.setFloat(3, 9.0F);
            preparedStatementForStudent.setFloat(4, 2);
            preparedStatementForStudent.executeUpdate();

            PreparedStatement preparedStatementForDeleteStudent = connection.prepareStatement(DELETE_STUDENT);
            preparedStatementForDeleteStudent.executeUpdate();

            PreparedStatement preparedStatementForDeleteCity = connection.prepareStatement(DELETE_CITY);
            preparedStatementForDeleteCity.executeUpdate();

            PreparedStatement students = connection.prepareStatement("SELECT * FROM student");
            ResultSet resultSet = students.executeQuery();
            while (resultSet.next()) {
                log.info("Student: id={} first_name={} last_name={} gpa={} city_id={}",
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getFloat("gpa"),
                        resultSet.getInt("city_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
