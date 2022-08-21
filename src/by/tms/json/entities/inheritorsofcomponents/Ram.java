package by.tms.json.entities.inheritorsofcomponents;

import by.tms.json.entities.characteristicsofcomputer.ComputerComponent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Ram extends ComputerComponent {

    private int volume;

    @JsonCreator
    public Ram(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("origin")String origin,
            @JsonProperty("price") double price,
            @JsonProperty("critical") boolean critical,
            @JsonProperty("volume") int volume) {
        super(id, name, origin, price, critical);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ram ram = (Ram) o;
        return volume == ram.volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volume);
    }

    @Override
    public String toString() {
        return "Ram{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", origin='" + getOrigin() + '\'' +
                ", price=" + getPrice() +
                ", critical=" + isCritical() +
                ", volume=" + volume +
                '}';
    }
}
