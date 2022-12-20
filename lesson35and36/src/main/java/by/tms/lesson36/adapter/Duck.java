package by.tms.lesson36.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Duck {
    private Lake lake;

    public Duck(){}

    public Duck(Lake lake){
        this.lake = lake;
    }

    public void swimOnTheLake() {
        log.info("Let's swim");
        lake.swim();
        log.info("Finish");
    }
}