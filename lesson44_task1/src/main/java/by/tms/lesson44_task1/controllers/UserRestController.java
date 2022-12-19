package by.tms.lesson44_task1.controllers;

import by.tms.lesson44_task1.entities.User;
import by.tms.lesson44_task1.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "User", description = "User API")
@RestController
@RequestMapping("/rest/user")
@AllArgsConstructor
public class UserRestController {

    private UserService userService;

    @GetMapping
    @Operation(summary = "Get all users")
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping
    @Operation(summary = "Create user")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody User user) {
        userService.create(user);
    }

    @GetMapping("{id}")
    @Operation(summary = "Get user by id")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PatchMapping
    @Operation(summary = "Update user login and password")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

}
