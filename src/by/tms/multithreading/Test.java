package by.tms.multithreading;

import by.tms.multithreading.entities.Assistant;
import by.tms.multithreading.entities.Dump;
import by.tms.multithreading.entities.Factory;
import by.tms.multithreading.entities.Scientist;

public class Test {

    public static void main(String[] args) {
        Dump dump = new Dump();
        Scientist scientistFirst = new Scientist();
        Scientist scientistSecond = new Scientist();

        Thread threadFactory = new Thread(new Factory(dump));
        Assistant assistantFirst = new Assistant(scientistFirst, dump);
        Assistant assistantSecond = new Assistant(scientistSecond, dump);

        Thread threadAssistantFirst = new Thread(assistantFirst);
        Thread threadAssistantSecond = new Thread(assistantSecond);
        threadAssistantFirst.setName("assistantFirst");
        threadAssistantSecond.setName("assistantSecond");

        threadFactory.start();
        threadAssistantFirst.start();
        threadAssistantSecond.start();

        try {
            threadFactory.join();
            threadAssistantFirst.join();
            threadAssistantSecond.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Scientist.getWinner(scientistFirst.countOfRobots(), scientistSecond.countOfRobots());
    }
}
