package by.tms.lesson8.triangles;

public class EquilateralTriangle extends Triangle {

    public EquilateralTriangle(String name, String color, double firstSide, double secondSide, double base) {
        super(name, color, firstSide, secondSide, base);
    }

    @Override
    public String getInfoAboutEqualityOfSides() {
        return "Треугольник равносторонний!";
    }
}
