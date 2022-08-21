package by.tms.json.entities.inheritorsofcomponents;

import by.tms.json.entities.characteristicsofcomputer.ComputerComponent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class HDD extends ComputerComponent {

    private int speed;

    @JsonCreator
    public HDD(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("origin") String origin,
            @JsonProperty("price") double price,
            @JsonProperty("critical") boolean critical,
            @JsonProperty("speed") int speed) {
        super(id, name, origin, price, critical);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HDD hdd = (HDD) o;
        return speed == hdd.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speed);
    }

    @Override
    public String toString() {
        return "HDD{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", origin='" + getOrigin() + '\'' +
                ", price=" + getPrice() +
                ", critical=" + isCritical() +
                ", speed=" + speed +
                '}';
    }
}
