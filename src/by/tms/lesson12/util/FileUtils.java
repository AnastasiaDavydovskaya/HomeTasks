package by.tms.lesson12.util;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public final class FileUtils {

    public static final String[] LETTERS = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о",
            "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};
    public static final int COUNT_OF_NUMBERS = 10;
    public static final String SPACE = " ";

    private FileUtils() {
    }

    public static void writeCountOfLettersInFile(File file) {
        if (file != null && file.exists() && file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                StringBuilder builder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

                countLettersInFile(builder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void countLettersInFile(String string) {
        if (string != null) {
            int temp = 0;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/letters.txt"))) {
                for (String letter : LETTERS) {
                    for (int j = 0; j < string.length(); j++) {
                        if (letter.equalsIgnoreCase(String.valueOf(string.charAt(j)))) {
                            temp++;
                        }
                    }
                    writer.write(letter + " - " + temp + "\n");
                    temp = 0;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createNewFileWithSortNumbers() {
        File file = createNewFile("resources/random numbers.txt");
        File fileToSort = createNewFile("resources/sort numbers.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            Random random = new Random();
            for (int i = 0; i < COUNT_OF_NUMBERS; i++) {
                writer.write(random.nextInt() + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            writeInFileOneString(sortNumbersFromString(reader.readLine()), fileToSort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String sortNumbersFromString(String string) {
        if (string != null) {
            String[] numbers = string.split(SPACE);
            int[] intNumbers = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                intNumbers[i] = Integer.parseInt(numbers[i]);
            }

            Arrays.sort(intNumbers);
            return Arrays.toString(intNumbers);
        }

        return "";
    }

    public static File createNewFile(String path) {
        if (path == null) {
            path = "resources/emptyFile.txt";
        }

        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    public static void writeInFileOneString(String str, File file) {
        if (str != null && file != null && file.exists() && file.isFile()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
