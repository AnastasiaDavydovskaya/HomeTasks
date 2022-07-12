package by.tms.lesson10.task1;

import java.util.Scanner;

public class TaskFirst {

    public static void main(String[] args) {
        System.out.print("Введите строку: ");
        String string = new Scanner(System.in).nextLine();

        System.out.println("Является ли строка палиндромом: " + isPalindrome(string));
    }

    public static boolean isPalindrome(String string) {
        if (string == null || string.isEmpty()) {
            return true;
        }
        return string.equalsIgnoreCase(new StringBuilder(string).reverse().toString());
    }
}
