package predko.ua.springstudents.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping ("api/students/add")
    public String addStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/update/{id}")
    public String updateStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "update-student";
    }
    @PostMapping ("api/students/update")
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.findById(id);
        if (student != null) {
            model.addAttribute("student", student);
        }
        return "delete-student";
    }

    @PostMapping("/api/students/delete_student/id/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
