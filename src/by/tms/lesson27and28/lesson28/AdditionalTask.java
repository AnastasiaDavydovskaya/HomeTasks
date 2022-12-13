package by.tms.lesson27and28.lesson28;

import by.tms.lesson27and28.lesson28.pojo.Address;
import by.tms.lesson27and28.lesson28.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class AdditionalTask {
    public static List<User> users = new ArrayList<>();

    public static void main(String[] args) throws CloneNotSupportedException {
        users.add(new User(0, "Nastya", "Davydovskaya", new Address("Olk", 12)));
        users.add(new User(1, "Mark", "Davydovskaya", new Address("Olk", 22)));
        users.add(new User(2, "Olga", "Davydovskaya", new Address("Olk", 9)));

        surfaceClone(1);
        deepClone(2);
    }

    private static void surfaceClone(int id) throws CloneNotSupportedException {
        User newUser = users.get(id).cloneSurface();

        System.out.println("Оригинал:\t" + users.get(id));
        System.out.println("Клон:   \t" + newUser);
    }

    private static void deepClone(int id) throws CloneNotSupportedException {
        User newUser = users.get(id).cloneDeep();

        System.out.println("Оригинал:\t" + users.get(id));
        System.out.println("Клон:   \t" + newUser);
    }
}
