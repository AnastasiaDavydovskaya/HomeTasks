package by.tms.json.entities.characteristicsofcomputer;

import by.tms.json.entities.inheritorsofcomponents.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "class")
@JsonSubTypes({
        @JsonSubTypes.Type(HDD.class),
        @JsonSubTypes.Type(Keyboard.class),
        @JsonSubTypes.Type(Monitor.class),
        @JsonSubTypes.Type(Ram.class),
        @JsonSubTypes.Type(Motherboard.class),
        @JsonSubTypes.Type(Battery.class),
        @JsonSubTypes.Type(Camera.class),
        @JsonSubTypes.Type(CPU.class)})
public abstract class ComputerComponent {

    private int id;
    private String name;
    private String origin;
    private double price;
    private boolean critical;

    public ComputerComponent(int id, String name, String origin, double price, boolean critical) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.critical = critical;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerComponent that = (ComputerComponent) o;
        return id == that.id && Double.compare(that.price, price) == 0 && critical == that.critical && Objects.equals(name, that.name) && Objects.equals(origin, that.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, origin, price, critical);
    }
}
