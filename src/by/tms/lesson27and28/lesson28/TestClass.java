package by.tms.lesson27and28.lesson28;

import by.tms.lesson27and28.lesson28.pojo.Address;
import by.tms.lesson27and28.lesson28.pojo.User;

public class TestClass {

    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new User(1,"Nastya", "Davydovskaya", new Address("Nezavisimosti", 45));
        User user2 = new User(2,"Mark", "Lokhad", new Address("Odincova", 24));
        User user3 = new User(3, "Nastya", "Davydovskaya", new Address("Lobanka", 10));

        System.out.println(user1.equals(user3));
        System.out.println(user1.equals(user2));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());

        System.out.println("==========================================");

        int i1 = 1;
        Integer i2 = new Integer(1);
        Integer i3 = Integer.valueOf(1);

        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
        System.out.println(i2 == i3);
        System.out.println(i2.equals(i3));

        System.out.println("==========================================");

        String hello1 = "Hello";
        String hello2 = "Hello";
        String hello3 = new String("Hello");

        System.out.println(hello1 == hello2);
        System.out.println(hello1 == hello3);
        System.out.println(hello2.equals(hello3));

        System.out.println("==========================================");

    }
}
