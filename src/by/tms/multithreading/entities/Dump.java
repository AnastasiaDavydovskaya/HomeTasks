package by.tms.multithreading.entities;

import java.util.*;

public class Dump {

    public static final List<String> DETAILS = Arrays.asList("Head", "Body", "Left hand", "Right hand", "Left foot", "Right foot", "CPU", "RAM", "HDD");
    private final Queue<String> DETAILS_OF_DUMP = new ArrayDeque<>();
    private final List<String> DETAILS_TO_SEND = new ArrayList<>();
    private final Random RANDOM = new Random();
    private final Object LOCK = new Object();

    public void addDetails() {
        synchronized (LOCK) {
            int count = new Random().nextInt(4) + 1;
            for (int j = 0; j < count; j++) {
                DETAILS_OF_DUMP.add(DETAILS.get(RANDOM.nextInt(DETAILS.size())));
            }

            System.out.println("Выброшено " + count + " деталей.");
        }
    }

    public List<String> getDetails() {
        synchronized (LOCK) {
            int count = new Random().nextInt(4) + 1;
            DETAILS_TO_SEND.clear();

            if (DETAILS_OF_DUMP.size() == 0) {
                    System.out.println("Помощник " + Thread.currentThread().getName() + " уходит ни с чем");
            } else {
                for (int j = 0; j < count; j++) {
                    DETAILS_TO_SEND.add(DETAILS_OF_DUMP.poll());
                    if (DETAILS_OF_DUMP.isEmpty()) {
                        break;
                    }
                }
                System.out.println("Помощник " + Thread.currentThread().getName() + " взял " + DETAILS_TO_SEND);
            }

            return DETAILS_TO_SEND;
        }
    }
}
