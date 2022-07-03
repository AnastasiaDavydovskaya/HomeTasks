package by.tms.lesson8.triangles;

import by.tms.lesson8.abstractfiles.Figure;

import java.util.Objects;

public class Triangle extends Figure {

    protected double firstSide;
    protected double secondSide;
    protected double base;

    public Triangle(String name, String color, double firstSide, double secondSide, double base) {
        super(name, color);
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.base = base;
    }

    @Override
    public double getSquare() {
        return (getHeight() * base) / 2;
    }

    @Override
    public double getPerimeter() {
        return firstSide + secondSide + base;
    }

    public double getSemiPerimeter() {
        return getPerimeter() / 2;
    }

    public double getHeight() {
        return (2 * Math.sqrt(getSemiPerimeter()
                * (getSemiPerimeter() - firstSide)
                * (getSemiPerimeter() - secondSide)
                * (getSemiPerimeter() - base)))
                / base;
    }

    public String getInfoAboutEqualityOfSides() {
        if (firstSide == secondSide && firstSide == base) {
            return "Ваш треугольник равносторонний.";
        } else if (firstSide == secondSide) {
            return "У треугольника боковые стороны равны.";
        } else {
            return "У треугольника боковые стороны неравны.";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.firstSide, firstSide) == 0 &&
                Double.compare(triangle.secondSide, secondSide) == 0 &&
                Double.compare(triangle.base, base) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstSide, secondSide, base);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "firstSide=" + firstSide +
                ", secondSide=" + secondSide +
                ", base=" + base +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public double getFirstSide() {
        return firstSide;
    }

    public void setFirstSide(double firstSide) {
        this.firstSide = firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public void setSecondSide(double secondSide) {
        this.secondSide = secondSide;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
}
