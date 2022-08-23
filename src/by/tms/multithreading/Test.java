package by.tms.multithreading;

import by.tms.multithreading.entities.Assistant;
import by.tms.multithreading.entities.Factory;
import by.tms.multithreading.entities.Scientist;

public class Test {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Scientist scientistFirst = new Scientist();
        Scientist scientistSecond = new Scientist();

        Thread threadAssistantFirst = new Thread(new Assistant(scientistFirst, factory, "assistantFirst"));
        Thread threadAssistantSecond = new Thread(new Assistant(scientistSecond, factory, "assistantSecond"));

        threadAssistantFirst.start();
        threadAssistantSecond.start();

        try {
            threadAssistantFirst.join();
            threadAssistantSecond.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Scientist.getWinner(scientistFirst.countOfRobots(), scientistSecond.countOfRobots());

    }
}
