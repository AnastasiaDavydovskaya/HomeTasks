package by.tms.lesson40.task1.repositories;

import by.tms.lesson40.task1.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@AllArgsConstructor
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    public Student create(Student student) {
        jdbcTemplate.update("INSERT INTO student(first_name, last_name, number_of_group, gpa) VALUES (?, ?, ?, ?);",
                student.getFirstName(),
                student.getLastName(),
                student.getNumberOfGroup(),
                student.getGPA());

        return student;
    }

    public List<Student> getStudents() {
        Stream<Student> studentStream = jdbcTemplate.queryForStream("SELECT * FROM student;",
                new BeanPropertyRowMapper<>(Student.class));

        return studentStream.collect(Collectors.toList());
    }
}
