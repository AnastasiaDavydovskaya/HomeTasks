package by.tms.json.entities.characteristicsofcomputer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Size {

    private double width;
    private double thickness;
    private double weight;

    @JsonCreator
    public Size(
            @JsonProperty("width") double width,
            @JsonProperty("thickness") double thickness,
            @JsonProperty("weight") double weight) {
        this.width = width;
        this.thickness = thickness;
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return Double.compare(size.width, width) == 0 && Double.compare(size.thickness, thickness) == 0 && Double.compare(size.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, thickness, weight);
    }

    @Override
    public String toString() {
        return "Size{" +
                "width=" + width +
                ", thickness=" + thickness +
                ", weight=" + weight +
                '}';
    }
}
