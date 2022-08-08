package by.tms.java8.task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Task2 {

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(
                new Person("Анастасия", "Иванова", 34),
                new Person("Ольга", "Гавриленко", 20),
                new Person("Ульяна", "Трамбовская", 18),
                new Person("Геннадий", "Фильчук", 57),
                new Person("Анатолий", "Урамский", 25),
                new Person("Аркадий-Иванович", "Алексиевич", 57),
                new Person("Аркадий", "Ламбордов", 37)
        );

        String personWithMaxAgeAndFixedNameLength = list.stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getFirstName() != null && person.getFirstName().length() <= 15)
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getFirstName)
                .orElse("Не найден");

        System.out.println(personWithMaxAgeAndFixedNameLength);
    }
}
