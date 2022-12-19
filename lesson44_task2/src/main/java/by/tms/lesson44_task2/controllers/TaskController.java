package by.tms.lesson44_task2.controllers;

import by.tms.lesson44_task2.entities.Task;
import by.tms.lesson44_task2.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

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
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/delete/{id}")
    public String delete(@PathVariable(value="id") Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/update/{id}")
    public String update(@PathVariable(value="id") Long id) {
        taskService.changeStatusOfTask(id);
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
