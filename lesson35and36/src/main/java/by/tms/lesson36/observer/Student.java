package by.tms.lesson36.observer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Student {

    private String name;

    public Student(String name, TMSGroup tmsGroup) {
        this.name = name;
        tmsGroup.addStudent(this);
    }

    public void update(String news) {
        log.info("{} узнал новость: {}", name, news);
    }
}
