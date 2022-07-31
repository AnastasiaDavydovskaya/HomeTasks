package by.tms.lesson13;

import by.tms.lesson13.task1.WordUtils;
import by.tms.lesson13.task2.Garage;
import by.tms.lesson13.task2.inheritors.FullSizeCar;
import by.tms.lesson13.task2.inheritors.SmallCar;
import by.tms.lesson13.task3.StringUtils;
import by.tms.lesson13.task4.Student;
import by.tms.lesson13.task4.StudentComparator;
import by.tms.lesson13.task4.util.StudentUtils;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestClass {

    public static void main(String[] args) {
        //task1
        Map<String, Integer> map = WordUtils.countEachWordInFile
                (Paths.get("resources", "lesson13", "text in english.txt").toFile());
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }

        //task2
        FullSizeCar car1 = new FullSizeCar("BMW", "X6", 2020, "синий", 300, 300);
        FullSizeCar car2 = new FullSizeCar("Mercedes", "L", 2003, "фиолетовый", 100, 20);
        FullSizeCar car3 = new FullSizeCar("Toyota", "P763", 1970, "красный", 250, 100);
        SmallCar car4 = new SmallCar("BMW", "X3", 2022, "синий", 300, true);
        FullSizeCar car5 = new FullSizeCar("BMW", "X6", 2020, "синий", 300, 300);
        Garage.parking(car1);
        Garage.parking(car2);
        Garage.parking(car3);
        Garage.parking(car4);
        Garage.parking(car5);
        System.out.println(Garage.getCountOfCars(car1));
        System.out.println(Garage.getCountOfCars(car2));
        System.out.println(Garage.getCountOfCars(car4));
        Garage.departure(car1);
        System.out.println(Garage.getCountOfCars(car5));

        //task3
        List<String> list = new ArrayList<>();
        list.add("this");
        list.add("is");
        list.add("lots");
        list.add("of");
        list.add("fun");
        list.add("for");
        list.add("every");
        list.add("Java");
        list.add("programmer");
        System.out.println(StringUtils.markLength4(list));

        //task4
        List<Student> studentList = StudentUtils.createAndFillList();
        System.out.println(StudentUtils.getStudentWithMaxAverageMark(studentList));
        studentList.sort(new StudentComparator());
        System.out.println(studentList);

    }
}
