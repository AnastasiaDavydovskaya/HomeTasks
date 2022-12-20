package by.tms.lesson40.task1.services;

import by.tms.lesson40.task1.entities.Student;
import by.tms.lesson40.task1.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public Student create(Student student) {
        return studentRepository.create(student);
    }

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }
}
