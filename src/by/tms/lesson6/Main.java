package by.tms.lesson6;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangleFirst = new Rectangle(new Point(0, 2), new Point(3, 0));
        System.out.println("Площадь прямоугольника: " + rectangleFirst.getSquare());
        System.out.println("Периметр прямоугольника: " + rectangleFirst.getPerimeter());
        System.out.println("Длина диагонали прямоугольника: " + rectangleFirst.getDiagonalLength() + "\n");

        Rectangle rectangleSecond = new Rectangle(new Point(3, 0), new Point(0, 2));
        System.out.println("Площадь прямоугольника: " + rectangleSecond.getSquare());
        System.out.println("Периметр прямоугольника: " + rectangleSecond.getPerimeter());
        System.out.println("Длина диагонали прямоугольника: " + rectangleSecond.getDiagonalLength());
    }
}
