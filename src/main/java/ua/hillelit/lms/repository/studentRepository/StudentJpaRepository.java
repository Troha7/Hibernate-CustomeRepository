package ua.hillelit.lms.repository.studentRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.hillelit.lms.model.Student;

/**
 * {@link StudentJpaRepository}
 *
 * @author Dmytro Trotsenko on 1/22/23
 */

@Repository
public interface StudentJpaRepository extends JpaRepository<Student,Integer>, CustomStudentRepository {

}
