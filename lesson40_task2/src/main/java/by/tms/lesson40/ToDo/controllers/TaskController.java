package by.tms.lesson40.ToDo.controllers;

import by.tms.lesson40.ToDo.entities.Task;
import by.tms.lesson40.ToDo.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @PostMapping("/addTask")
    public String create(@ModelAttribute("task") Task task) {
        taskService.addTask(task.getDescription());
        return "redirect:/tasks";
    }

    @PostMapping("/changeTask")
    public String change(@ModelAttribute("task") Task task) {
        taskService.changeStatusOfTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/deleteTask")
    public String delete(@ModelAttribute("task") Task task) {
        taskService.deleteTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/add")
    public String addTask(Model model) {
        model.addAttribute("task", Task.builder().build());
        return "add";
    }

    @GetMapping("/change")
    public String changeStatusTask(Model model) {
        model.addAttribute("task", Task.builder().build());
        return "change";
    }

    @GetMapping("/delete")
    public String deleteTask(Model model) {
        model.addAttribute("task", Task.builder().build());
        return "delete";
    }
}
