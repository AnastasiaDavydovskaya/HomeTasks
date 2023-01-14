package by.tms.lesson49.services;

import by.tms.lesson49.dto.TaskDto;
import by.tms.lesson49.entities.Status;
import by.tms.lesson49.entities.Task;
import by.tms.lesson49.mapper.TaskMapper;
import by.tms.lesson49.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Transactional
    public void create(TaskDto taskDto) {
        taskRepository.save(taskMapper.toTask(taskDto));
    }

    @Transactional
    public void deleteById(Long id) {
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(Status.DONE);
                taskRepository.save(task);
            }
        }
    }

    @Transactional
    public void changeStatusOfTask(Long id) {
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(Status.IN_PROGRESS);
                taskRepository.save(task);
            }
        }
    }

    public Page<Task> getTasks(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Task> list;

        List<Task> tasks = taskRepository.findAll();

        if (tasks.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, tasks.size());
            list = tasks.subList(startItem, toIndex);
        }

        return new PageImpl<Task>(list, PageRequest.of(currentPage, pageSize), tasks.size());
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }
}
