package by.tms.lesson29.task3;

import java.util.WeakHashMap;

public class TaskThird {

    public static void main(String[] args) {
        WeakHashMap map = new WeakHashMap<>();
        String bigImageFirst = "foo";
        String imageNameFirst = "name_of_big_image";

        String bigImageSecond = "foo_2";
        String imageNameSecond = "name_of_big_image_2";

        map.put(imageNameFirst, bigImageFirst);
        map.put(imageNameSecond, bigImageSecond);

        imageNameFirst = null;
        System.gc();

        System.out.println(map);
    }
}
