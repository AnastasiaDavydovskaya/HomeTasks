package by.tms.lesson43.entities;

import jakarta.validation.constraints.Size;
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
