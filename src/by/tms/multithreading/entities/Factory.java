package by.tms.multithreading.entities;

import java.util.Random;

public class Factory implements Runnable {

    private Dump dump;

    public Factory(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            dump.addDetails();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
