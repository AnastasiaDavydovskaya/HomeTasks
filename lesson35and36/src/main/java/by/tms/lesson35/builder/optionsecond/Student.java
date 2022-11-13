package by.tms.lesson35.builder.optionsecond;

import lombok.Builder;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
@Builder
public class Student {

    private String firstName;
    private String lastName;
    private String patronymic;
    private Double gpa;
    private Integer age;
    private String numberOfGroup;
    private List<String> favouriteSubjects;
    private List<String> favouriteTeachers;

}
