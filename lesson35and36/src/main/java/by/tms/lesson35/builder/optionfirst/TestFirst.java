package by.tms.lesson35.builder.optionfirst;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class TestFirst {

    public static void main(String[] args) {
        Student student = new Student.Builder()
                .firstName("Nastya")
                .lastName("Davydovskaya")
                .patronymic("Vladzimirovna")
                .gpa(8.6)
                .age(20)
                .numberOfGroup("01-onl")
                .favouriteSubjects(List.of("Math", "English"))
                .favouriteTeachers(List.of("Olexnovich", "Atroshenko"))
                .build();

        log.info("Student: {}", student);
    }
}
