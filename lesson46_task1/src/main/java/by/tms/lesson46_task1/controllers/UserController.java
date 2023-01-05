package by.tms.lesson46_task1.controllers;

import by.tms.lesson46_task1.dto.UserDto;
import by.tms.lesson46_task1.entities.Role;
import by.tms.lesson46_task1.entities.User;
import by.tms.lesson46_task1.services.UserService;
import by.tms.lesson46_task1.services.ValidationService;
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
public class UserController {

    private UserService userService;
    private ValidationService validationService;

    @ModelAttribute("user")
    public User getTask() {
        return User.builder().build();
    }

    @GetMapping("/")
    public String getMainPage() {
        return "mainPage";
    }

    @GetMapping("/enter")
    public String enterInSystem() {
        return "enter";
    }

    @GetMapping("/registration")
    public String registrationInSystem() {
        return "registration";
    }

    @GetMapping("/check")
    public String checkAuthorization(User user) {
        Role role = validationService.validateUser(user.getLogin(), user.getPassword());
        if (Role.ADMIN.equals(role)) {
            return "adminPage";
        } else if (Role.CUSTOMER.equals(role)) {
           return "customerPage";
        } else {
            return "error";
        }
    }

    @GetMapping("/list/users")
    public String getListUsers(Model model) {
        model.addAttribute("users", userService.findUserFromDb());
        return "listUsers";
    }

    @GetMapping("/customerPage")
    public String getCustomerPage() {
        return "customerPage";
    }

    @GetMapping("/adminPage")
    public String getAdminPage() {
        return "adminPage";
    }

    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable(value="id") Long id) {
        userService.delete(id);
        return "redirect:/list/users";
    }

    @PostMapping("/save/user")
    public String create(@Valid UserDto userDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "error";
        }

        userService.create(userDto);
        return "redirect:/customerPage";
    }

}
