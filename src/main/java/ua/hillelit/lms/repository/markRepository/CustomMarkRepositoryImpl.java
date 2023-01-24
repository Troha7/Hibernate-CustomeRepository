package ua.hillelit.lms.repository.markRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import ua.hillelit.lms.model.Mark;

import java.util.List;
import java.util.Optional;

/**
 * {@link CustomMarkRepositoryImpl} is a class for implement custom methods to {@link MarkJpaRepository}.
 *
 * @author Dmytro Trotsenko on 1/22/23
 */
public class CustomMarkRepositoryImpl implements CustomMarkRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void updateMarkValueByStudentIdAndDiscipline(Integer id, String discipline, Integer value) {

        Query query = entityManager
                .createQuery("UPDATE Mark m SET m.value = :value WHERE m.student.id = :id AND m.discipline = :discipline");
        query.setParameter("id", id);
        query.setParameter("discipline", discipline);
        query.setParameter("value", value);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void removeMark(Integer id) {

        Query query = entityManager
                .createQuery("DELETE FROM Mark m WHERE m.id = :markId");
        query.setParameter("markId", id);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public Optional findMarkById(Integer id) {
        Query query = entityManager
                .createQuery("FROM Mark m WHERE m.id = :markId");
        query.setParameter("markId", id);
        return query.getResultStream()
                .findFirst();
    }

    @Override
    @Transactional
    public List<Mark> findAllMarks() {
        Query query = entityManager
                .createQuery("FROM Mark");
        return query.getResultList();
    }
}
