package by.tms.lesson8.rectangles;

public class FourSquare extends Rectangle {

    public FourSquare(String name, String color, double length, double width) {
        super(name, color, length, width);
    }

    @Override
    public String differenceBetweenLengthAndWidth() {
        return "У квадрата все стороны равны!";
    }
}
