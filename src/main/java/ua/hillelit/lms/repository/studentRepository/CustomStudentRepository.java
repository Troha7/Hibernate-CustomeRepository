package ua.hillelit.lms.repository.studentRepository;

import ua.hillelit.lms.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * {@link CustomStudentRepository}
 *
 * @author Dmytro Trotsenko on 1/21/23
 */
public interface CustomStudentRepository {

    void updateStudentById(Integer id, String name, String email);

    void removeStudent(Integer id);

    Optional findStudentById(Integer id);

    List<Student> findAllStudents();

}
