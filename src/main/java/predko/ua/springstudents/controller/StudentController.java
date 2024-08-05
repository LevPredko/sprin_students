package predko.ua.springstudents.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import predko.ua.springstudents.model.Student;
import predko.ua.springstudents.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    public List<Student> findAllStudent() {
        return service.findAllStudent();
    }

    @PostMapping("save_student")
    public Student saveStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping("email/{email}")
    public Student findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @GetMapping("id/{id}")
    public Student findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("delete_student/email/{email}")
    public void deleteStudentByEmail(@PathVariable String email) {
        service.deleteStudentByEmail(email);
    }
    @DeleteMapping("delete_student/id/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        service.deleteStudentById(id);
    }
}
