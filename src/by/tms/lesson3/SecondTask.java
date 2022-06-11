package by.tms.lesson3;

import java.util.Scanner;

public class SecondTask {

    public static void main(String[] args) {
        System.out.print("Введите целое число: ");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int first = 0;
        int second = 1;
        int result;

        if (number >= 1) {
            System.out.print("0 1 ");

            for (int i = 0; i < number; i++) {
                result = first + second;
                first = second;
                second = result;

                if (result >= number) {
                    break;
                }

                System.out.print(result + " ");
            }
        } else {
            System.out.println("Введите положительное число от 1.");
        }

    }
}
