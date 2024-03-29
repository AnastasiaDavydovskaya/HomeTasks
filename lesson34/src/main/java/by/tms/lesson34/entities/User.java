package by.tms.lesson34.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private String login;
    private String password;
    private Role role;
}
