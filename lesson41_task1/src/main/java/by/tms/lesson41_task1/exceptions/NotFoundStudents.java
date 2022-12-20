package by.tms.lesson41_task1.exceptions;

public class NotFoundStudents extends RuntimeException{

    public NotFoundStudents(String message) {
        super(message);
    }
}
