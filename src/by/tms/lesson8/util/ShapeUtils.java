package by.tms.lesson8.util;

import by.tms.lesson8.abstractfiles.Figure;
import by.tms.lesson8.rectangles.Rectangle;
import by.tms.lesson8.triangles.Triangle;

public final class ShapeUtils {

    private ShapeUtils() {
    }

    public static boolean isRectangle(Figure figure) {
        return figure instanceof Rectangle;
    }

    public static boolean isTriangle(Figure figure) {
        return figure instanceof Triangle;
    }
}
