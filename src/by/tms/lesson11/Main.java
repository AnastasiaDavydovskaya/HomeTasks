package by.tms.lesson11;

import by.tms.lesson11.exception.UncheckedException;
import by.tms.lesson11.util.ExceptionUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            ExceptionUtils.generateNullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            ExceptionUtils.generateArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        try {
            ExceptionUtils.generateIllegalArgumentException();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            ExceptionUtils.generateNumberFormatException();
        } catch (NumberFormatException e) {
            try {
                throw new UncheckedException("NumberFormatException был словлен");
            } catch (UncheckedException e1) {
                e.printStackTrace();
            }
        }

        try {
            ExceptionUtils.generateThreeExceptions(3, 0);
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя.");
        } catch (NullPointerException e) {
            System.out.println("Параметр/параметры равен null.");
        } catch (Exception e) {
            System.out.println("Ошибка вычисления.");
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("line.txt"));
            ExceptionUtils.generateFileNotFoundException(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
