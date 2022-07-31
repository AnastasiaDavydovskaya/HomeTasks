package by.tms.lesson13.task3;

import java.util.*;

public final class StringUtils {

    public static final String ELEMENT = "****";

    private StringUtils() {
    }

    public static List<String> markLength4(List<String> list) {
        if (list != null) {
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i).length() == 4) {
                    list.add(i, ELEMENT);
                }
            }
        }

        return list;
    }
}
