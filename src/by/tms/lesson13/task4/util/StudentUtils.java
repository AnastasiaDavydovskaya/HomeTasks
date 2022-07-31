package by.tms.lesson13.task4.util;

import by.tms.lesson13.task4.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class StudentUtils {

    private StudentUtils() {
    }

    public static List<Student> createAndFillList() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Оля", "Макан", 20, 8.3));
        list.add(new Student("Оля", "Аиш", 20, 7.2));
        list.add(new Student("Ира", "Оркун", 19, 9.3));
        list.add(new Student("Ира", "Оркун", 20, 10.0));
        list.add(new Student("Ира", "Оркун", 20, 6.2));
        list.add(new Student("Ульяна", "Магур", 21, 6.1));
        list.add(new Student("Алексей", "Фильчук", 22, 7.5));

        return list;
    }

    public static Student getStudentWithMaxAverageMark(List<Student> list) {
        if (list != null) {
            Iterator<Student> iterator = list.iterator();
            double maxAverageMark = 0;
            Student studentWithMaxAverageMark = null;
            while (iterator.hasNext()) {
                Student student = iterator.next();
                double mark = student.getAverageMark();
                if (maxAverageMark < mark) {
                    maxAverageMark = mark;
                    studentWithMaxAverageMark = student;
                }
            }

            return studentWithMaxAverageMark;
        }

        return new Student();
    }

}
