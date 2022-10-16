package by.tms.lesson29.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TaskFirst {

    public static void main(String[] args) {
        Map<String, Document> map = new HashMap();
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("resources/lesson29/contacts.txt"))) {
            String s;
            while (( s = reader.readLine()) != null) {
                if (!map.containsKey(s)) {
                    if(!list.contains(s)) {
                        map.put(s, new Document(s,
                                LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(
                                        LocalDate.of(1970, 1, 1).toEpochDay(),
                                        LocalDate.of(2015, 12, 31).toEpochDay()))));
                    }
                } else {
                    list.add(s);
                    for(String element: list) {
                        if (map.containsKey(element)) {
                            map.remove(s);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Document> entry : map.entrySet()) {
            System.out.println("Ключ =  " + entry.getKey() + " Значение = " + entry.getValue().getDate());
        }
    }
}
