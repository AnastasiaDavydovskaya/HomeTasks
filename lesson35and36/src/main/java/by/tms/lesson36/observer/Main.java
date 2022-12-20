package by.tms.lesson36.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        TMSGroup tmsGroup = new TMSGroup();

        new Student("Анастасия", tmsGroup);
        new Student("Ольга", tmsGroup);

        tmsGroup.setNews("Занятие начнется в 19.00");
    }
}
