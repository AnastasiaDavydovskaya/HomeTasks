package by.tms.lesson40.task1.controllers;

import by.tms.lesson40.task1.entities.Student;
import by.tms.lesson40.task1.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String create(@ModelAttribute("student") Student student) {
        studentService.create(student);
        return "redirect:/students";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("student", Student.builder().build());
        return "form";
    }
}
