package by.tms.lesson13.task2.inheritors;

import by.tms.lesson13.task2.Car;

import java.util.Objects;

public class SmallCar extends Car {

    private boolean trunk;

    public SmallCar(String brand, String model, int year, String color, int maxSpeed, boolean trunk) {
        super(brand, model, year, color, maxSpeed);
        this.trunk = trunk;
    }

    public boolean isTrunk() {
        return trunk;
    }

    public void setTrunk(boolean trunk) {
        this.trunk = trunk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmallCar smallCar = (SmallCar) o;
        return trunk == smallCar.trunk;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trunk);
    }

    @Override
    public String toString() {
        return "SmallCar{" +
                "trunk=" + trunk +
                '}';
    }
}
