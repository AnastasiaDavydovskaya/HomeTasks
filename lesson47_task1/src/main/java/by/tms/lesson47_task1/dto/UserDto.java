package by.tms.lesson47_task1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String login;
    @Size(min = 7, message = "Пароль должен содержать не менее 7 символов")
    private String password;
}
