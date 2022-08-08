package by.tms.java8.task1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 4, 2, 1);

        String str = list.stream()
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(str);
    }
}
