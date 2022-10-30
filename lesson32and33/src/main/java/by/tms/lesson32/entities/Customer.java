package by.tms.lesson32.entities;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Customer extends User {

    private String name;
    private String address;
}
