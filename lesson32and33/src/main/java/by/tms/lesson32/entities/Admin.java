package by.tms.lesson32.entities;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Admin extends User {

    private String login;
    private String password;
}
