package by.tms.lesson13.task1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public final class WordUtils {

    public static final String SPACE = " ";

    private WordUtils() {
    }

    public static Map<String, Integer> countEachWordInFile(File file) {
        Map<String, Integer> map = new HashMap<>();
        if (file != null && file.exists() && file.isFile()) {
            String text = openFileForRead(file);
            for (String word : text.split(SPACE)) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        return map;
    }

    public static String openFileForRead(File file) {
        if (file != null && file.exists() && file.isFile()) {
            StringBuilder builder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line).append(" ");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return builder.toString();
        }

        return "";
    }
}
