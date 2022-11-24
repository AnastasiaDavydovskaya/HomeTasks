package by.tms.lesson38.ToDo.services;

import by.tms.lesson38.ToDo.entities.Status;
import by.tms.lesson38.ToDo.entities.Task;
import by.tms.lesson38.ToDo.repositories.TaskRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
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
