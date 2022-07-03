package by.tms.lesson8.rectangles;

import by.tms.lesson8.abstractfiles.Figure;

import java.util.Objects;

public class Rectangle extends Figure {

    protected double length;
    protected double width;

    public Rectangle(String name, String color, double length, double width) {
        super(name, color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getSquare() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return length + length + width + width;
    }

    public String differenceBetweenLengthAndWidth() {
        return "Разница длины и ширины у прямоугольника составляет: " + (length - width);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.length, length) == 0 &&
                Double.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
