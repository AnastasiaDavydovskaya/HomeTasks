package by.tms.lesson29.task2;

import java.util.*;

public class TaskSecond {

    public static void main(String[] args) {
        List<User> listUsers = new ArrayList<>();
        String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < 1000; i++) {
            StringBuilder builder = new StringBuilder();
            int length = new Random().nextInt(5)+5;
            for(int j = 0; j < length; j++) {
                builder.append(lexicon.charAt(new Random().nextInt(lexicon.length())));
            }
            listUsers.add(new User(builder.toString(), 1 + (int) (Math.random() * 100)));
        }

        Set<User> setUsers = new HashSet<>(listUsers);

        List<User> sortedUsers = setUsers.stream()
                .sorted(Comparator.comparing(User::getAge).reversed()).toList();

        for(int i = 0; i < 10; i++) {
            System.out.println(sortedUsers.get(i));
        }
    }
}
