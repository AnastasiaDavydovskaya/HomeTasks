package by.tms.json.entities.inheritorsofcomponents;

import by.tms.json.entities.characteristicsofcomputer.ComputerComponent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Touchpad extends ComputerComponent {

    private int countOfButtons;

    @JsonCreator
    public Touchpad(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("origin") String origin,
            @JsonProperty("price") double price,
            @JsonProperty("critical") boolean critical,
            @JsonProperty("button") int countOfButtons) {
        super(id, name, origin, price, critical);
        this.countOfButtons = countOfButtons;
    }

    public int getButton() {
        return countOfButtons;
    }

    public void setButton(int countOfButtons) {
        this.countOfButtons = countOfButtons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Touchpad touchpad = (Touchpad) o;
        return countOfButtons == touchpad.countOfButtons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countOfButtons);
    }

    @Override
    public String toString() {
        return "Touchpad{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", origin='" + getOrigin() + '\'' +
                ", price=" + getPrice() +
                ", critical=" + isCritical() +
                ", button=" + countOfButtons +
                '}';
    }
}
