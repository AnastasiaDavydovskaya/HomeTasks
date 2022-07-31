package by.tms.lesson13.task2.inheritors;

import by.tms.lesson13.task2.Car;

import java.util.Objects;

public class MidsizeCar extends Car {

    private int countOfDoors;

    public MidsizeCar(String brand, String model, int year, String color, int maxSpeed, int countOfDoors) {
        super(brand, model, year, color, maxSpeed);
        this.countOfDoors = countOfDoors;
    }

    public int getCountOfDoors() {
        return countOfDoors;
    }

    public void setCountOfDoors(int countOfDoors) {
        this.countOfDoors = countOfDoors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MidsizeCar that = (MidsizeCar) o;
        return countOfDoors == that.countOfDoors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfDoors);
    }

    @Override
    public String toString() {
        return "MidsizeCar{" +
                "countOfDoors=" + countOfDoors +
                '}';
    }
}
