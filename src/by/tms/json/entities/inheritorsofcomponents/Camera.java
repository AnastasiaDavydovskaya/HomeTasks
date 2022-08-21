package by.tms.json.entities.inheritorsofcomponents;

import by.tms.json.entities.characteristicsofcomputer.ComputerComponent;

import java.util.Objects;

public class Camera extends ComputerComponent {

    private int numberOfPixels;

    public Camera(int id, String name, String origin, double price, boolean critical, int numberOfPixels) {
        super(id, name, origin, price, critical);
        this.numberOfPixels = numberOfPixels;
    }

    public int getNumberOfPixels() {
        return numberOfPixels;
    }

    public void setNumberOfPixels(int numberOfPixels) {
        this.numberOfPixels = numberOfPixels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Camera camera = (Camera) o;
        return numberOfPixels == camera.numberOfPixels;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfPixels);
    }

    @Override
    public String toString() {
        return "Camera{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", origin='" + getOrigin() + '\'' +
                ", price=" + getPrice() +
                ", critical=" + isCritical() +
                ", numberOfPixels=" + numberOfPixels +
                '}';
    }
}
