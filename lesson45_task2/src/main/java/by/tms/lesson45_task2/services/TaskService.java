package by.tms.lesson45_task2.services;

import by.tms.lesson45_task2.entities.Status;
import by.tms.lesson45_task2.entities.Task;
import by.tms.lesson45_task2.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepository taskRepository;

    public void addTask(Task task) {
        task.setStatus(Status.TO_DO);
        taskRepository.addTask(task);
    }

    public void deleteTask(Long id) {
        List<Task> tasks = taskRepository.readTasks();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(Status.DONE);
                taskRepository.changeStatusOfTask(task);
            }
        }
    }

    public void changeStatusOfTask(Long id) {
        List<Task> tasks = taskRepository.readTasks();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(Status.IN_PROGRESS);
                taskRepository.changeStatusOfTask(task);
            }
        }
    }

    public List<Task> getTasks() {
        return taskRepository.readTasks();
    }
}
