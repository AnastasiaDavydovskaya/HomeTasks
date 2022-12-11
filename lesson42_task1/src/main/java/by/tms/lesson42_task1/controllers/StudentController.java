package by.tms.lesson42_task1.controllers;

import by.tms.lesson42_task1.entities.Student;
import by.tms.lesson42_task1.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @ModelAttribute("student")
    public Student getStudent() {
        return Student.builder().build();
    }

    @GetMapping("/")
    public String getStartPage() {
        return "index";
    }

    @GetMapping("/students")
    public ModelAndView findAll(ModelAndView modelAndView) {
        modelAndView.addObject("students", studentService.getStudents());
        modelAndView.setViewName("students");
        return modelAndView;
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
        return "form";
    }

    @GetMapping("/students/delete/{id}")
    public String delete(@PathVariable(value="id") Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
