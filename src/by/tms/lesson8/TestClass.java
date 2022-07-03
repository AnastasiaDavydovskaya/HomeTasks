package by.tms.lesson8;

import by.tms.lesson8.circles.Circle;
import by.tms.lesson8.rectangles.FourSquare;
import by.tms.lesson8.rectangles.Rectangle;
import by.tms.lesson8.triangles.EquilateralTriangle;
import by.tms.lesson8.triangles.IsoscelesTriangle;
import by.tms.lesson8.triangles.Triangle;
import by.tms.lesson8.util.ShapeUtils;

public class TestClass {

    public static void main(String[] args) {
        Circle circle = new Circle("Круг", "Красный", 5);
        Rectangle fourSquare = new FourSquare("Квадрат", "Зеленый", 4, 4);
        Rectangle rectangle = new Rectangle("Прямоугольник", "Фиолетовый", 5, 3);
        Triangle equilateralTriangle = new EquilateralTriangle("Равносторонний", "Белый", 4, 4, 4);
        Triangle isoscelesTriangle = new IsoscelesTriangle("Равнобедренный", "Желтый", 5, 5, 6);
        Triangle triangle = new Triangle("Треугольник", "Голубой", 8, 4, 6);

        System.out.println("Площадь круга: " + circle.getSquare());
        System.out.println("Периметр круга: " + circle.getPerimeter() + "\n");

        System.out.println("Площадь квадрата: " + fourSquare.getSquare());
        System.out.println("Периметр квадрата: " + fourSquare.getPerimeter());
        System.out.println(fourSquare.differenceBetweenLengthAndWidth() + "\n");

        System.out.println("Площадь прямоугольника: " + rectangle.getSquare());
        System.out.println("Периметр прямоугольника: " + rectangle.getPerimeter());
        System.out.println(rectangle.differenceBetweenLengthAndWidth() + "\n");

        System.out.println("Площадь равностороннего треугольника: " + equilateralTriangle.getSquare());
        System.out.println("Периметр равностороннего треугольника: " + equilateralTriangle.getPerimeter());
        System.out.println(equilateralTriangle.getInfoAboutEqualityOfSides() + "\n");

        System.out.println("Площадь треугольника: " + triangle.getSquare());
        System.out.println("Периметр треугольника: " + triangle.getPerimeter());
        System.out.println(triangle.getInfoAboutEqualityOfSides() + "\n");

        System.out.println("Является ли круг прямоугольником: " + ShapeUtils.isRectangle(circle));
        System.out.println("Является ли равнобедренный треугольник треугольником: " + ShapeUtils.isTriangle(isoscelesTriangle));
    }
}
