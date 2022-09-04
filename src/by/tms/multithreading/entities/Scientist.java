package by.tms.multithreading.entities;

import java.util.ArrayList;
import java.util.List;

public class Scientist {

    private final List<String> DETAILS_OF_SCIENTIST = new ArrayList<>();

    public int countOfRobots() {
        int count = 0;
        while (DETAILS_OF_SCIENTIST.containsAll(Dump.DETAILS)) {
            count++;
            for (String detail : Dump.DETAILS) {
                DETAILS_OF_SCIENTIST.remove(detail);
            }
        }
        return count;
    }

    public void addDetails(List<String> detail) {
        this.DETAILS_OF_SCIENTIST.addAll(detail);
    }

    public static void getWinner(int numberOfRobotsFirstScientist, int numberOfRobotsSecondScientist) {
        System.out.println("Первый ученый собрал " + numberOfRobotsFirstScientist);
        System.out.println("Второй ученый собрал " + numberOfRobotsSecondScientist);

        if (numberOfRobotsFirstScientist > numberOfRobotsSecondScientist) {
            System.out.println("Победил первый ученый");
        } else if (numberOfRobotsSecondScientist > numberOfRobotsFirstScientist) {
            System.out.println("Победил второй ученый");
        } else System.out.println("Ничья");
    }
}
