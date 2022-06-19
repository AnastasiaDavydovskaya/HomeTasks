package by.tms.lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class SecondTask {

    public static void main(String[] args) {
        int[] numbers = {167, -2, 16, 99, 26, 92, 43, 80, 99, 80};

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число для удаления: ");
        int numberToDelete = scanner.nextInt();

        int count = 0;
        for (int number : numbers) {
            if (number == numberToDelete) {
                count++;
            }
        }

        int[] copyNumbers = new int[numbers.length - count];
        int index = 0;
        for (int number : numbers) {
            if (number != numberToDelete) {
                copyNumbers[index] = number;
                index++;
            }
        }

        System.out.println(Arrays.toString(copyNumbers));
    }
}
