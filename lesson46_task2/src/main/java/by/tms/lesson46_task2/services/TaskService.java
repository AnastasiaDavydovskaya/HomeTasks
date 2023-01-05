package by.tms.lesson46_task2.services;

import by.tms.lesson46_task2.dto.TaskDto;
import by.tms.lesson46_task2.entities.Status;
import by.tms.lesson46_task2.entities.Task;
import by.tms.lesson46_task2.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepository taskRepository;

    public void addTask(TaskDto taskDto) {
        taskRepository.addTask(Task.builder()
                .description(taskDto.getDescription())
                .status(Status.TO_DO)
                .build());
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

    public List<TaskDto> getTasksDto() {
        return taskRepository.readTasks()
                .stream()
                .map(task -> TaskDto.builder().description(task.getDescription()).build())
                .collect(Collectors.toList());
    }

    public List<Task> getTasks() {
        return taskRepository.readTasks();
    }
}
