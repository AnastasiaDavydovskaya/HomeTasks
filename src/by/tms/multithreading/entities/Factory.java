package by.tms.multithreading.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Factory {

    public static final List<String> DETAILS = Arrays.asList("Head", "Body", "Left hand", "Right hand", "Left foot", "Right foot", "CPU", "RAM", "HDD");
    private final List<String> DETAILS_OF_FACTORY = new ArrayList<>();
    private final Random RANDOM = new Random();

    public void createFirstFactory() {
        for (int i = 0; i < 20; i++) {
            DETAILS_OF_FACTORY.add(DETAILS.get(RANDOM.nextInt(DETAILS.size())));
        }
        System.out.println("Выброшено " + 20 + " деталей.");
        System.out.println("На свалке " + DETAILS_OF_FACTORY.size() + " деталей");
    }

    public void createFactory() {
        int count = RANDOM.nextInt(4) + 1;
        for (int i = 0; i < count; i++) {
            DETAILS_OF_FACTORY.add(DETAILS.get(RANDOM.nextInt(DETAILS.size())));
        }
        System.out.println("Выброшено " + count + " деталей.");
        System.out.println("На свалке " + DETAILS_OF_FACTORY.size() + " деталей");
    }

    public List<String> getDetailsOfFactory() {
        return DETAILS_OF_FACTORY;
    }

    public void deleteDetail(String detail) {
        DETAILS_OF_FACTORY.remove(detail);
    }
}
