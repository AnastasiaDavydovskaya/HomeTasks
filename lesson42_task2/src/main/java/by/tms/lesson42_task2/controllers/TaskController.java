package by.tms.lesson42_task2.controllers;

import by.tms.lesson42_task2.entities.Task;
import by.tms.lesson42_task2.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @ModelAttribute("task")
    public Task getTask() {
        return Task.builder().build();
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @PostMapping("/addTask")
    public String create(@Valid Task task, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "add";
        }
        taskService.addTask(task.getDescription());
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/delete/{description}")
    public String delete(@PathVariable(value="description") String description) {
        taskService.deleteTask(description);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/update/{description}")
    public String update(@PathVariable(value="description") String description) {
        taskService.changeStatusOfTask(description);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/add")
    public String addTask() {
        return "add";
    }
}
