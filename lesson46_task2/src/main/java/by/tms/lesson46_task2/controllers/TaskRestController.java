package by.tms.lesson46_task2.controllers;

import by.tms.lesson46_task2.dto.TaskDto;
import by.tms.lesson46_task2.entities.Task;
import by.tms.lesson46_task2.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Task", description = "Task API")
@RestController
@RequestMapping("/rest/todo")
@AllArgsConstructor
public class TaskRestController {

    private final TaskService taskService;

    @GetMapping
    @Operation(summary = "Get all tasks")
    public List<TaskDto> getAll() {
        return taskService.getTasksDto();
    }

    @PostMapping
    @Operation(summary = "Create task")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody TaskDto taskDto) {
        taskService.addTask(taskDto);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PatchMapping("{id}")
    @Operation(summary = "Update status")
    public void update(@PathVariable Long id) {
        taskService.changeStatusOfTask(id);
    }

}
