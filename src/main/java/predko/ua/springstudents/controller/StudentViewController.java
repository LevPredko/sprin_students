package predko.ua.springstudents.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import predko.ua.springstudents.model.Student;
import predko.ua.springstudents.service.StudentService;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentViewController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String viewStudents(Model model) {
        List<Student> students = studentService.findAllStudent();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }
}
