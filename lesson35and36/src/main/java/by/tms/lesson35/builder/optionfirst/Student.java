package by.tms.lesson35.builder.optionfirst;

import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
public class Student {

    private String firstName;
    private String lastName;
    private String patronymic;
    private Double gpa;
    private Integer age;
    private String numberOfGroup;
    private List<String> favouriteSubjects;
    private List<String> favouriteTeachers;

    public static class Builder {

        private Student student;

        public Builder() {
            this.student = new Student();
        }

        public Builder firstName(String firstName) {
            this.student.setFirstName(firstName);
            return this;
        }

        public Builder lastName(String lastName) {
            this.student.setLastName(lastName);
            return this;
        }

        public Builder patronymic(String patronymic) {
            this.student.setPatronymic(patronymic);
            return this;
        }

        public Builder gpa(Double gpa) {
            this.student.setGpa(gpa);
            return this;
        }

        public Builder age(Integer age) {
            this.student.setAge(age);
            return this;
        }

        public Builder numberOfGroup(String numberOfGroup) {
            this.student.setNumberOfGroup(numberOfGroup);
            return this;
        }

        public Builder favouriteSubjects(List<String> favouriteSubjects) {
            this.student.setFavouriteSubjects(favouriteSubjects);
            return this;
        }

        public Builder favouriteTeachers(List<String> favouriteTeachers) {
            this.student.setFavouriteTeachers(favouriteTeachers);
            return this;
        }

        public Student build() {
            return this.student;
        }
    }
}
