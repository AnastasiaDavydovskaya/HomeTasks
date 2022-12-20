package by.tms.lesson41_task1.controllers;

import by.tms.lesson41_task1.entities.Student;
import by.tms.lesson41_task1.services.StudentService;
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
public class StudentController {

    private StudentService studentService;

    @GetMapping("/students")
    public String findAll(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "students";
    }

    @PostMapping("/students")
    public String create(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        studentService.create(student);
        return "redirect:/students";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("student", Student.builder().build());
        return "form";
    }

    @GetMapping("/students/delete/{id}")
    public String delete(@PathVariable(value="id") Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
