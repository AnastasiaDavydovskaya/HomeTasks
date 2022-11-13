package by.tms.lesson36.observer;

import java.util.ArrayList;
import java.util.List;

public class TMSGroup implements Group{

    private List<Student> students;
    private String news;

    public TMSGroup() {
        this.students = new ArrayList<>();
    }

    public void setNews(String news) {
        this.news = news;
        notifyStudents();
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public void notifyStudents() {
        for(Student student: students) {
            student.update(news);
        }
    }
}
