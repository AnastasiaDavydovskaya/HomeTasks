package by.tms.lesson44_task2.repositories;

import by.tms.lesson44_task2.entities.Status;
import by.tms.lesson44_task2.entities.Task;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Repository
public class TaskRepository {

    private static final String INSERT_TASK = "INSERT INTO task (description, status) VALUES (?, ?);";
    private static final String UPDATE_STATUS = "UPDATE task SET status = ? WHERE id = ?;";
    private static final String SELECT_TASKS = "SELECT * FROM task;";

    private JdbcTemplate jdbcTemplate;

    public void addTask(Task task) {
        jdbcTemplate.update(INSERT_TASK,
                task.getDescription(),
                task.getStatus().name());
    }

    public void changeStatusOfTask(Task task) {
        jdbcTemplate.update(UPDATE_STATUS, String.valueOf(task.getStatus()), task.getId());
    }

    public List<Task> readTasks() {
        Stream<Task> stream = jdbcTemplate.queryForStream(SELECT_TASKS, new BeanPropertyRowMapper<>(Task.class));
        return stream.collect(Collectors.toList());
    }
}
