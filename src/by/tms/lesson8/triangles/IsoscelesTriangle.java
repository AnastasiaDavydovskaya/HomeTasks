package by.tms.lesson8.triangles;

public class IsoscelesTriangle extends Triangle {

    public IsoscelesTriangle(String name, String color, double firstSide, double secondSide, double base) {
        super(name, color, firstSide, secondSide, base);
    }

    @Override
    public String getInfoAboutEqualityOfSides() {
        return "Треугольник равнобедренный!";
    }
}
