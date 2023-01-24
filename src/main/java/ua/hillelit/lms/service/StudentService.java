package ua.hillelit.lms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ua.hillelit.lms.dto.StudentDto;
import ua.hillelit.lms.model.Student;
import ua.hillelit.lms.repository.studentRepository.StudentJpaRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * {@link StudentService}
 *
 * @author Dmytro Trotsenko on 1/21/23
 */

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentJpaRepository studentJpaRepository;
    private final ObjectMapper objectMapper;

    /**
     * Create new entity {@link Student} and save row with data in database
     *
     * @param studentDto object with data
     * @return studentDto
     */
    public StudentDto createStudent(StudentDto studentDto) {

        Student student = objectMapper.convertValue(studentDto, Student.class);
        studentJpaRepository.save(student);
        studentDto.setId(student.getId());
        return studentDto;
    }

    /**
     * Update student info at database
     *
     * @param id    student id
     * @param name  student name
     * @param email student email
     */
    public void updateStudentById(Integer id, String name, String email) {
        studentJpaRepository.updateStudentById(id, name, email);
    }

    /**
     * Remove student info from database
     *
     * @param id student id
     */
    public void removeStudent(Integer id) {
        studentJpaRepository.removeStudent(id);
    }

    /**
     * Find the student by id.
     *
     * @param id student id
     * @return {@link StudentDto}
     * @throws EntityNotFoundException if student id wasn't found
     */
    @SneakyThrows
    public StudentDto findStudentById(Integer id) {
        var studentModel = studentJpaRepository.findStudentById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with id=" + id + " wasn't found"));
        return objectMapper.convertValue(studentModel, StudentDto.class);
    }

    /**
     * Find all students from database.
     *
     * @return all students
     */
    public List<StudentDto> findAllStudents() {
        List<Student> students = studentJpaRepository.findAllStudents();
        return students.stream()
                .map(s -> objectMapper.convertValue(s, StudentDto.class))
                .collect(toList());
    }

}
