package by.tms.lesson47_task2.controllers;

import by.tms.lesson47_task2.dto.TaskDto;
import by.tms.lesson47_task2.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @ModelAttribute("task")
    public TaskDto getTask() {
        return TaskDto.builder().build();
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @PostMapping("/addTask")
    public String create(@Valid TaskDto taskDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "error";
        }
        taskService.create(taskDto);

        return "redirect:/tasks";
    }

    @GetMapping("/tasks/delete/{id}")
    public String delete(@PathVariable(value="id") Long id) {
        taskService.deleteById(id);
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


}
