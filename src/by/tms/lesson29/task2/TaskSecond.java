package by.tms.lesson29.task2;

import by.tms.lesson29.task2.utils.GenerateNamesUtil;

import java.util.*;

public class TaskSecond {

    public static void main(String[] args) {
        List<User> listUsers = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            listUsers.add(new User(GenerateNamesUtil.generateName(), 1 + (int) (Math.random() * 100)));
        }

        Set<User> setUsers = new HashSet<>(listUsers);

        setUsers.stream()
                .sorted(Comparator.comparing(User::getAge).reversed())
                .limit(10)
                .forEach(System.out::println);
    }
}
