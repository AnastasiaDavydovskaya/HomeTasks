package by.tms.lesson36.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Duck duck = new Duck(new RiverAdapter());
        duck.swimOnTheLake();
    }
}
