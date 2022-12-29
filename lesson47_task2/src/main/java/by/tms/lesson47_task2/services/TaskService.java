package by.tms.lesson47_task2.services;

import by.tms.lesson47_task2.dto.TaskDto;
import by.tms.lesson47_task2.entities.Status;
import by.tms.lesson47_task2.entities.Task;
import by.tms.lesson47_task2.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepository taskRepository;

    public void create(TaskDto taskDto) {
        taskRepository.save(Task.builder()
                .description(taskDto.getDescription())
                .status(Status.TO_DO)
                .build());
    }

    public void deleteById(Long id) {
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(Status.DONE);
                taskRepository.save(task);
            }
        }
    }

    public void changeStatusOfTask(Long id) {
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(Status.IN_PROGRESS);
                taskRepository.save(task);
            }
        }
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
}
