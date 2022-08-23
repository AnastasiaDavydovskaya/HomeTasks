package by.tms.multithreading.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assistant implements Runnable {

    private final List<String> details = new ArrayList<>();
    private final Random random = new Random();
    private Factory factory;
    private String name;
    private Scientist scientist;

    public Assistant(Scientist scientist, Factory factory, String name) {
        this.scientist = scientist;
        this.factory = factory;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (factory.getDetailsOfFactory()) {
            factory.createFirstFactory();
            sendElementsToScientist(20);
        }

        for (int i = 0; i < 99; i++) {
            synchronized (factory.getDetailsOfFactory()) {
                factory.createFactory();
                int count = random.nextInt(4) + 1;
                sendElementsToScientist(count);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void sendElementsToScientist(int count) {
        details.clear();
        if (factory.getDetailsOfFactory().isEmpty()) {
            System.out.println("Помощник " + name + " уходит ни с чем");
        } else {
            for (int j = 0; j < count; j++) {
                String detail = factory.getDetailsOfFactory().get(random.nextInt(factory.getDetailsOfFactory().size()));
                details.add(detail);
                scientist.addDetails(details);
                factory.deleteDetail(detail);
                if (factory.getDetailsOfFactory().isEmpty()) {
                    break;
                }
            }
            System.out.println("Помощник " + name + " взял " + details);
        }
    }
}
