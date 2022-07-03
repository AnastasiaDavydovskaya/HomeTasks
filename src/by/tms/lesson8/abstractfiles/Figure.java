package by.tms.lesson8.abstractfiles;

public abstract class Figure implements Measurable, Definable {

    protected String name;
    protected String color;

    public Figure(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public boolean isEqualSquare(Figure figure) {
        return figure.getSquare() == this.getSquare();
    }

    @Override
    public boolean isEqualPerimeter(Figure figure) {
        return figure.getPerimeter() == this.getPerimeter();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
