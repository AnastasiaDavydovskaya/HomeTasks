package by.tms.lesson42_task1.services;

import by.tms.lesson42_task1.entities.Student;
import by.tms.lesson42_task1.exceptions.NotFoundStudents;
import by.tms.lesson42_task1.repositories.StudentRepository;
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
        List<Student> students = studentRepository.getStudents();
        if(students.isEmpty()) {
            throw new NotFoundStudents("Cannot find students");
        }

        return studentRepository.getStudents();
    }

    public void delete(Long id) {
        studentRepository.delete(id);
    }
}
