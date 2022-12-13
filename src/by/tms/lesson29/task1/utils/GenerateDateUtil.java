package by.tms.lesson29.task1.utils;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public final class GenerateDateUtil {

    private GenerateDateUtil() {}

    public static LocalDate generateDate() {
         return LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(
                LocalDate.of(1970, 1, 1).toEpochDay(),
                LocalDate.now().toEpochDay()));
    }
}
