package by.tms.regularexpressionsanddates.task3and4.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public final class DatesUtils {

    private DatesUtils() {
    }

    public static long amountOfDays(int year, int month, int day) {
        return ChronoUnit.DAYS.between(createLocalDateAtDate(year, month, day), createLocalDateNow());
    }

    public static long amountOfSeconds(int year, int month, int day) {
        return ChronoUnit.SECONDS.between(createLocalDateAtDate(year, month, day).atStartOfDay(), createLocalDateNow().atStartOfDay());
    }

    private static LocalDate createLocalDateNow() {
        return LocalDate.now();
    }

    private static LocalDate createLocalDateAtDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }
}
