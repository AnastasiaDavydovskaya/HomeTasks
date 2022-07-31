package by.tms.lesson13.task2;

import java.util.HashMap;
import java.util.Map;

public class Garage {

    private static Map<Car, Integer> map = new HashMap<>();

    public static void parking(Car car) {
        if (car != null) {
            if (!map.containsKey(car)) {
                map.put(car, 1);
            } else {
                map.replace(car, map.get(car) + 1);
            }
        }
    }

    public static void departure(Car car) {
        if (car != null) {
            if (map.containsKey(car)) {
                map.replace(car, map.get(car) - 1);
            }
        }
    }

    public static int getCountOfCars(Car car) {
        if (car != null) {
            return map.get(car);
        }

        return 0;
    }

}
