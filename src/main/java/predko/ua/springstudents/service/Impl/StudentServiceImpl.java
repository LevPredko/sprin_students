package predko.ua.springstudents.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import predko.ua.springstudents.model.Student;
import predko.ua.springstudents.ropository.StudentRepository;
import predko.ua.springstudents.service.StudentService;

import java.util.List;

@Primary
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    @Override
    public List<Student> findAllStudent() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findStudentByEmail(email);
    }

    @Override
    public Student findById(Long id) {
        return repository.findStudentById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudentByEmail(String email) {
        repository.deleteByEmail(email);
    }

    @Override
    @Transactional
    public void deleteStudentById(Long id) {
        repository.deleteById(id);
    }
}