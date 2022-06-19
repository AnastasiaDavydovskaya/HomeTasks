package by.tms.lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class ThirdTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();

        System.out.print("Введите количество столбцов: ");
        int columns = scanner.nextInt();

        int[][] arrayFirst = new int[rows][columns];
        int[] arraySecond = new int[rows * columns];

        int index = 0;
        System.out.print("Введите " + (rows * columns) + " чисел: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arrayFirst[i][j] = scanner.nextInt();
                arraySecond[index++] = arrayFirst[i][j];
            }
        }

        System.out.println("Двумерный массив: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arrayFirst[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Одномерный массив со всеми элементами двумерного: " + Arrays.toString(arraySecond));
    }
}
