package by.tms.lesson39.ToDo.services;

import by.tms.lesson39.ToDo.entities.Status;
import by.tms.lesson39.ToDo.entities.Task;
import by.tms.lesson39.ToDo.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepository taskRepository;

    public void addTask(String description) {
        taskRepository.addTask(new Task(description, Status.TO_DO));
    }

    public void deleteTask(Task task) {
        task.setStatus(Status.DONE);
        taskRepository.changeStatusOfTask(task);
    }

    public void changeStatusOfTask(Task task) {
        task.setStatus(Status.IN_PROGRESS);
        taskRepository.changeStatusOfTask(task);
    }

    public List<Task> getTasks() {
        return taskRepository.readTasks();
    }
}
