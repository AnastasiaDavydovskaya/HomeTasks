package by.tms.lesson29.task2.utils;

import java.util.Random;

public final class GenerateNamesUtil {

    private GenerateNamesUtil() {}

    public static String generateName() {
        String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder builder = new StringBuilder();
        int length = new Random().nextInt(5) + 5;
        for (int j = 0; j < length; j++) {
            builder.append(lexicon.charAt(new Random().nextInt(lexicon.length())));
        }

        return builder.toString();
    }
}
