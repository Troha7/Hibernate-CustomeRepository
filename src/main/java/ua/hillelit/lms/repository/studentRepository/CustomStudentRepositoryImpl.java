package ua.hillelit.lms.repository.studentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import ua.hillelit.lms.model.Student;

import java.util.List;
import java.util.Optional;

/**
 * {@link CustomStudentRepositoryImpl} is a class for implement custom methods to {@link StudentJpaRepository}.
 *
 * @author Dmytro Trotsenko on 1/22/23
 */
public class CustomStudentRepositoryImpl implements CustomStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void updateStudentById(Integer id, String name, String email) {

        Query query = entityManager
                .createQuery("UPDATE Student s SET s.name = :studentName, s.email = :studentEmail " +
                        "WHERE s.id = :studentId");
        query.setParameter("studentId", id);
        query.setParameter("studentName", name);
        query.setParameter("studentEmail", email);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void removeStudent(Integer id) {

        Query query = entityManager
                .createQuery("DELETE FROM Student s WHERE s.id = :studentId");
        query.setParameter("studentId", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public Optional findStudentById(Integer id) {
        Query query = entityManager
                .createQuery("FROM Student s WHERE s.id = :studentId");
        query.setParameter("studentId", id);
        return query.getResultStream()
                .findFirst();
    }

    @Override
    @Transactional
    public List<Student> findAllStudents() {
        Query query = entityManager
                .createQuery("FROM Student");
        return query.getResultList();
    }
}
