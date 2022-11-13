package by.tms.lesson35.factory_method.entities;

import lombok.ToString;

@ToString(callSuper = true)
public class Bus extends Transport {

    public Bus() {
        setLand(true);
        setColor("Blue");
    }
}
