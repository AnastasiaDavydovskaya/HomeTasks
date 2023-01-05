package by.tms.lesson44_task1.entities;

import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
