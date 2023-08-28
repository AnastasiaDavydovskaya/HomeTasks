package by.tms.lesson49.controllers;

import by.tms.lesson49.dto.TaskDto;
import by.tms.lesson49.entities.Result;
import by.tms.lesson49.entities.Task;
import by.tms.lesson49.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @ModelAttribute("task")
    public TaskDto getTask() {
        return TaskDto.builder().build();
    }

    @GetMapping("/")
    public String findAll(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Task> tasksPage = taskService.getTasks(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("tasksPage", tasksPage);

        int totalPages = tasksPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "tasks.html";
    }

    @PostMapping("/addTask")
    public String create(@Valid TaskDto taskDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("result", Result.MAX_LENGTH.name());
            return "error";
        }
        taskService.create(taskDto);

        return "redirect:/";
    }

    @GetMapping("/tasks/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        taskService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/tasks/update/{id}")
    public String update(@PathVariable(value = "id") Long id) {
        taskService.changeStatusOfTask(id);
        return "redirect:/";
    }
}
