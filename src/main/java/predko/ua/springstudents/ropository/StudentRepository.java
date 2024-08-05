package predko.ua.springstudents.ropository;

import org.springframework.data.jpa.repository.JpaRepository;
import predko.ua.springstudents.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteByEmail(String email);
    void deleteById(Long id);

    Student findStudentByEmail(String email);

    Student findStudentById(Long id);
}
