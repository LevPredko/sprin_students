package predko.ua.springstudents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import predko.ua.springstudents.model.Student;
import predko.ua.springstudents.service.Impl.StudentServiceImpl;
import predko.ua.springstudents.ropository.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceImplTest {

    @Mock
    private StudentRepository repository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllStudent_ShouldReturnAllStudents() {
        List<Student> students = List.of(new Student(), new Student());
        when(repository.findAll()).thenReturn(students);

        List<Student> result = studentService.findAllStudent();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void saveStudent_ShouldSaveAndReturnStudent() {
        Student student = new Student();
        when(repository.save(student)).thenReturn(student);

        Student result = studentService.saveStudent(student);

        assertNotNull(result);
        assertEquals(student.getEmail(), result.getEmail());
        verify(repository, times(1)).save(student);
    }

    @Test
    void findByEmail_ShouldReturnStudentByEmail() {
        Student student = new Student();
        when(repository.findStudentByEmail("john@example.com")).thenReturn(student);

        Student result = studentService.findByEmail("john@example.com");

        assertNotNull(result);
        assertEquals(student.getEmail(), result.getEmail());
        verify(repository, times(1)).findStudentByEmail("john@example.com");
    }

    @Test
    void findById_ShouldReturnStudentById() {
        Student student = new Student();
        when(repository.findStudentById(1552L)).thenReturn(student);

        Student result = studentService.findById(1552L);

        assertNotNull(result);
        assertEquals(student.getId(), result.getId());
        verify(repository, times(1)).findStudentById(1552L);
    }

    @Test
    void updateStudent_ShouldUpdateAndReturnStudent() {
        Student student = new Student();
        when(repository.save(student)).thenReturn(student);

        Student result = studentService.updateStudent(student);

        assertNotNull(result);
        assertEquals(student.getEmail(), result.getEmail());
        verify(repository, times(1)).save(student);
    }

    @Test
    void deleteStudentByEmail_ShouldDeleteStudentByEmail() {
        String email = "john@example.com";
        doNothing().when(repository).deleteByEmail(email);

        studentService.deleteStudentByEmail(email);

        verify(repository, times(1)).deleteByEmail(email);
    }

    @Test
    void deleteStudentById_ShouldDeleteStudentById() {
        Long id = 1L;
        doNothing().when(repository).deleteById(id);

        studentService.deleteStudentById(id);

        verify(repository, times(1)).deleteById(id);
    }
}
