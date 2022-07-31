package by.tms.lesson13.task4;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        int cmp1 = firstStudent.getName().compareTo(secondStudent.getName());
        if (cmp1 != 0) {
            return cmp1;
        }

        int cmp2 = firstStudent.getSurname().compareTo(secondStudent.getSurname());
        if (cmp2 != 0) {
            return cmp2;
        }

        int cmp3 = Integer.compare(firstStudent.getAge(), secondStudent.getAge());
        if (cmp3 != 0) {
            return cmp3;
        }

        return Double.compare(firstStudent.getAverageMark(), secondStudent.getAverageMark());
    }
}
