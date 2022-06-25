package by.tms.lesson6;

public class Rectangle {

    private Point firstPoint;
    private Point secondPoint;

    public Rectangle(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public Rectangle() {
    }

    public double getPerimeter() {
        return getLength() + getLength() + getWidth() + getWidth();
    }

    public double getSquare() {
        return getLength() * getWidth();
    }

    public double getDiagonalLength() {
        return firstPoint.getDistance(secondPoint);
    }

    public double getWidth() {
        if (firstPoint.getX() < secondPoint.getX()) {
            return firstPoint.getDistance(new Point(firstPoint.getX(), secondPoint.getY()));
        } else {
            return firstPoint.getDistance(new Point(secondPoint.getX(), firstPoint.getY()));
        }
    }

    public double getLength() {
        if (firstPoint.getY() > secondPoint.getY()) {
            return firstPoint.getDistance(new Point(secondPoint.getX(), firstPoint.getY()));
        } else {
            return firstPoint.getDistance(new Point(firstPoint.getX(), secondPoint.getY()));
        }
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }
}
