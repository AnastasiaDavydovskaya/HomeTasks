package by.tms.lesson48.services;

import by.tms.lesson48.dto.TaskDto;
import by.tms.lesson48.entities.Status;
import by.tms.lesson48.entities.Task;
import by.tms.lesson48.repositories.TaskHibernateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskHibernateRepository taskHibernateRepository;

    public void create(TaskDto taskDto) {
        taskHibernateRepository.save(Task.builder()
                .description(taskDto.getDescription())
                .status(Status.TO_DO)
                .build());
    }

    public void deleteById(Long id) {
        List<Task> tasks = taskHibernateRepository.findAll();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(Status.DONE);
                taskHibernateRepository.save(task);
            }
        }
    }

    public void changeStatusOfTask(Long id) {
        List<Task> tasks = taskHibernateRepository.findAll();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(Status.IN_PROGRESS);
                taskHibernateRepository.save(task);
                break;
            }
        }
    }

    public List<Task> getTasks() {
        return taskHibernateRepository.findAll();
    }
}
