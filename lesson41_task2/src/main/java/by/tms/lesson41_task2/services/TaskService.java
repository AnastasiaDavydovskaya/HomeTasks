package by.tms.lesson41_task2.services;

import by.tms.lesson41_task2.entities.Status;
import by.tms.lesson41_task2.entities.Task;
import by.tms.lesson41_task2.repositories.TaskRepository;
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

    public void deleteTask(String description) {
        List<Task> tasks = taskRepository.readTasks();
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.setStatus(Status.DONE);
                taskRepository.changeStatusOfTask(task);
            }
        }
    }

    public void changeStatusOfTask(String description) {
        List<Task> tasks = taskRepository.readTasks();
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.setStatus(Status.IN_PROGRESS);
                taskRepository.changeStatusOfTask(task);
            }
        }
    }

    public List<Task> getTasks() {
        return taskRepository.readTasks();
    }
}
