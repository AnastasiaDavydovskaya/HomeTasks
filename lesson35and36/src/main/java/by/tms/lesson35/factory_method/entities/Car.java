package by.tms.lesson35.factory_method.entities;

import lombok.ToString;

@ToString(callSuper = true)
public class Car extends Transport {

    public Car() {
        setLand(true);
        setColor("Yellow");
    }
}
