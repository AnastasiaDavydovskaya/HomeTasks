package by.tms.lesson10.task2;

import java.util.Scanner;

public class TaskSecond {

    private static final int[] ARABIC_SYMBOLS = {0, 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] ROMAN_SYMBOLS = {"", "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число в римском формате: ");
        String roman = scanner.nextLine();
        int arabic = toArabic(roman);

        System.out.println("Число в римском формате: " + roman + ", число в арабском формате: " + arabic);
    }

    public static int toArabic(String roman) {
        int result = 0;
        for (int i = ARABIC_SYMBOLS.length - 1; i >= 0; i--) {
            while (roman.indexOf(ROMAN_SYMBOLS[i]) == 0 && ROMAN_SYMBOLS[i].length() > 0) {
                result += ARABIC_SYMBOLS[i];
                roman = roman.substring(ROMAN_SYMBOLS[i].length());
            }
            if (roman.length() == 0) {
                break;
            }
        }
        return result;
    }
}
