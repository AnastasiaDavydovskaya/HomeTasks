package by.tms.lesson32.entities;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Admin extends User {

    private String login;
    private String password;

    public Admin(Long id, Integer daysOfActivity, String login, String password) {
        super(id, daysOfActivity);
        this.login = login;
        this.password = password;
    }
}
