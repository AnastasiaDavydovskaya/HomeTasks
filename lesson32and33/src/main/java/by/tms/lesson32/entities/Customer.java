package by.tms.lesson32.entities;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Customer extends User {

    private String name;
    private String address;

    public Customer(Long id, Integer daysOfActivity, String name, String address) {
        super(id, daysOfActivity);
        this.name = name;
        this.address = address;
    }
}
