package by.tms.lesson37.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private String login;
    private String password;
    private Role role;
}
