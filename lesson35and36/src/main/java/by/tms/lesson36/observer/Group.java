package by.tms.lesson36.observer;

public interface Group {

    void addStudent(Student student);
    void removeStudent(Student student);
    void notifyStudents();
}
