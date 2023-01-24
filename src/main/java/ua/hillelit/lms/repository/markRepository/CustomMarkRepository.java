package ua.hillelit.lms.repository.markRepository;

import ua.hillelit.lms.model.Mark;

import java.util.List;
import java.util.Optional;

/**
 * {@link CustomMarkRepository}
 *
 * @author Dmytro Trotsenko on 1/21/23
 */
public interface CustomMarkRepository {

    void updateMarkValueByStudentIdAndDiscipline(Integer id, String discipline, Integer value);

//    void updateMarksByStudentId(Integer id, String d,Integer v);

    void removeMark(Integer id);

    Optional findMarkById(Integer id);

    List<Mark> findAllMarks();

}
