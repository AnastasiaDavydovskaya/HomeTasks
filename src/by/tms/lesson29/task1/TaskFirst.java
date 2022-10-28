package by.tms.lesson29.task1;

import by.tms.lesson29.task1.utils.GenerateDateUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class TaskFirst {

    public static void main(String[] args) {
        Map<String, Document> map = new HashMap();
        Set<Object> set = new HashSet<>();

        try (Stream<String> lines = Files.lines(Paths.get("resources/lesson29/contacts.txt"))) {
            lines.forEach(line -> {
                if (!set.contains(line)) {
                    set.add(line);
                } else {
                    set.remove(line);
                }
            });

            set.stream()
                    .forEach(element -> map.put((String) element,
                            new Document((String) element, GenerateDateUtil.generateDate())));
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(map);
    }
}
