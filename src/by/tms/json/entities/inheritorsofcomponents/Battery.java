package by.tms.json.entities.inheritorsofcomponents;

import by.tms.json.entities.characteristicsofcomputer.ComputerComponent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Battery extends ComputerComponent {

    private double timeOfWork;

    @JsonCreator
    public Battery(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("origin") String origin,
            @JsonProperty("price") double price,
            @JsonProperty("critical") boolean critical,
            @JsonProperty("timeOfWork") double timeOfWork) {
        super(id, name, origin, price, critical);
        this.timeOfWork = timeOfWork;
    }

    public double getTimeOfWork() {
        return timeOfWork;
    }

    public void setTimeOfWork(double timeOfWork) {
        this.timeOfWork = timeOfWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Battery battery = (Battery) o;
        return Double.compare(battery.timeOfWork, timeOfWork) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timeOfWork);
    }

    @Override
    public String toString() {
        return "Battery{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", origin='" + getOrigin() + '\'' +
                ", price=" + getPrice() +
                ", critical=" + isCritical() +
                ", timeOfWork=" + timeOfWork +
                '}';
    }
}
