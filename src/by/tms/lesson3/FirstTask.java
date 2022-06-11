package by.tms.lesson3;

import java.util.Scanner;

public class FirstTask {

    public static void main(String[] args) {
        System.out.print("Введите целое число: ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }

        System.out.println("Сумма цифр: " + result);
    }
}
