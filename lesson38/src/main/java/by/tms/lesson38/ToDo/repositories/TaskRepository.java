package by.tms.lesson38.ToDo.repositories;

import by.tms.lesson38.ToDo.configs_db.MySqlConfig;
import by.tms.lesson38.ToDo.entities.Status;
import by.tms.lesson38.ToDo.entities.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private static final String INSERT_TASK = "INSERT INTO task (description, status) VALUES (?, ?);";
    private static final String UPDATE_STATUS = "UPDATE task SET status = ? WHERE description = ?;";
    private static final String SELECT_TASKS = "SELECT * FROM task;";

    public Connection init() {
        try {
            return MySqlConfig.createConnectionWithDatabase();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTask(Task task) {
        try (Connection connection = init()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASK);
            preparedStatement.setString(1, task.getDescription());
            preparedStatement.setString(2, String.valueOf(task.getStatus()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeStatusOfTask(Task task) {
        try (Connection connection = init()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATUS);
            preparedStatement.setString(1, String.valueOf(task.getStatus()));
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Task> readTasks() {
        List<Task> taskList = new ArrayList<>();
        try (Connection connection = init()) {
            ResultSet resultSet = connection.prepareStatement(SELECT_TASKS).executeQuery();
            while (resultSet.next()) {
                taskList.add(new Task(
                                resultSet.getString("description"),
                                Status.valueOf(resultSet.getString("status"))
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return taskList;
    }
}
