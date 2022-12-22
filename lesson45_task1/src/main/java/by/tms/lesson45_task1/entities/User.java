package by.tms.lesson45_task1.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String login;
    @Size(min = 7, message = "Пароль должен содержать не менее 7 символов")
    private String password;
    private Role role;
}
