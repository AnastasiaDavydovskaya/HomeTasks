package by.tms.lesson13.task2.inheritors;

import by.tms.lesson13.task2.Car;

import java.util.Objects;

public class MiniCar extends Car {

    private int countOfSeats;

    public MiniCar(String brand, String model, int year, String color, int maxSpeed, int countOfSeats) {
        super(brand, model, year, color, maxSpeed);
        this.countOfSeats = countOfSeats;
    }

    public int getCountOfSeats() {
        return countOfSeats;
    }

    public void setCountOfSeats(int countOfSeats) {
        this.countOfSeats = countOfSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MiniCar miniCar = (MiniCar) o;
        return countOfSeats == miniCar.countOfSeats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfSeats);
    }

    @Override
    public String toString() {
        return "MiniCar{" +
                "countOfSeats=" + countOfSeats +
                '}';
    }
}
