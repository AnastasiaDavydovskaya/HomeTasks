package by.tms.lesson11.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public final class ExceptionUtils {

    private ExceptionUtils() {
    }

    public static void generateNullPointerException() {
        Object object = null;
        object.toString();
    }

    public static void generateArrayIndexOutOfBoundsException() {
        int[] array = new int[10];
        array[-3] = 4;
    }

    public static void generateIllegalArgumentException() {
        new Random().nextInt(-3);
    }

    public static void generateNumberFormatException() {
        int number = Integer.parseInt("surprise");
    }

    public static void generateThreeExceptions(Integer firstNumber, Integer secondNumber) {
        Integer result = firstNumber / secondNumber;
    }

    public static void generateFileNotFoundException(BufferedReader reader) throws IOException {
        reader.readLine();
    }
}
