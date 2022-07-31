package by.tms.lesson13.task2.inheritors;

import by.tms.lesson13.task2.Car;

import java.util.Objects;

public class FullSizeCar extends Car {

    private int capacity;

    public FullSizeCar(String brand, String model, int year, String color, int maxSpeed, int capacity) {
        super(brand, model, year, color, maxSpeed);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullSizeCar that = (FullSizeCar) o;
        return capacity == that.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity);
    }

    @Override
    public String toString() {
        return "FullSizeCar{" +
                "capacity=" + capacity +
                '}';
    }
}
