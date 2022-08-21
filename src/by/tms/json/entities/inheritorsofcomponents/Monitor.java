package by.tms.json.entities.inheritorsofcomponents;

import by.tms.json.entities.characteristicsofcomputer.ComputerComponent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Monitor extends ComputerComponent {

    private double screenDiagonal;

    @JsonCreator
    public Monitor(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("origin") String origin,
            @JsonProperty("price") double price,
            @JsonProperty("critical") boolean critical,
            @JsonProperty("screenDiagonal") double screenDiagonal) {
        super(id, name, origin, price, critical);
        this.screenDiagonal = screenDiagonal;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monitor monitor = (Monitor) o;
        return Double.compare(monitor.screenDiagonal, screenDiagonal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), screenDiagonal);
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", origin='" + getOrigin() + '\'' +
                ", price=" + getPrice() +
                ", critical=" + isCritical() +
                ", screenDiagonal=" + screenDiagonal +
                '}';
    }
}
