package by.tms.lesson39.ToDo.repositories;

import by.tms.lesson39.ToDo.entities.Task;
import by.tms.lesson39.ToDo.mappers.TaskMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Repository
public class TaskRepository {

    private static final String INSERT_TASK = "INSERT INTO task (description, status) VALUES (?, ?);";
    private static final String UPDATE_STATUS = "UPDATE task SET status = ? WHERE description = ?;";
    private static final String SELECT_TASKS = "SELECT * FROM task;";

    private JdbcTemplate jdbcTemplate;

    public void addTask(Task task) {
        jdbcTemplate.update(INSERT_TASK, task.getDescription(), String.valueOf(task.getStatus()));
    }

    public void changeStatusOfTask(Task task) {
        jdbcTemplate.update(UPDATE_STATUS, String.valueOf(task.getStatus()), task.getDescription());
    }

    public List<Task> readTasks() {
        Stream<Task> stream = jdbcTemplate.queryForStream(SELECT_TASKS, new TaskMapper());
        return stream.collect(Collectors.toList());
    }
}
