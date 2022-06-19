package by.tms.lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class FirstTask {

    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        System.out.print("Введите элементы массива: ");

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(array));

        int empty_place;
        for (int i = array.length - 2; i >= 0; i--) {
            empty_place = array[i];
            array[i] = array[i + 1];
            array[i + 1] = empty_place;
        }

        System.out.println(Arrays.toString(array));
    }
}
