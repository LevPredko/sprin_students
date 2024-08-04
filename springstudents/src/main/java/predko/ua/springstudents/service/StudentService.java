package predko.ua.springstudents.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import predko.ua.springstudents.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    Student saveStudent(Student student);
    Student findByEmail(String email);
    Student updateStudent(Student student);
    void deleteStudent(String email);
}

