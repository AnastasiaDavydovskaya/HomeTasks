package by.tms.lesson3;

import java.util.Scanner;

public class ThirdTask {

    public static void main(String[] args) {
        System.out.print("Введите количество дней: ");

        Scanner scanner = new Scanner(System.in);
        int days = scanner.nextInt();

        int sum = 0;
        int max = 0;
        int count;
        for (int i = 1; i <= days; i++) {
            System.out.print("Введите величину осадков за " + i + " день: ");
            count = scanner.nextInt();
            if (count > max) {
                max = count;
            }
            sum += count;
        }

        System.out.println("Количество дней: " + days);
        System.out.println("Сумма осадков за весь период: " + sum);
        System.out.println("Среднее количество осадков за весь период: " + (sum / days));
        System.out.println("Максимальное количество осадков за весь период: " + max);
    }

}

