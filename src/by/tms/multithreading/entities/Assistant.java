package by.tms.multithreading.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assistant implements Runnable {

    private Scientist scientist;
    private Dump dump;

    public Assistant(Scientist scientist, Dump dump) {
        this.scientist = scientist;
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            scientist.addDetails(dump.getDetails());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
