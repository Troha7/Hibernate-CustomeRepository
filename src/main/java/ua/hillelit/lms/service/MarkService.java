package ua.hillelit.lms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ua.hillelit.lms.dto.MarkDto;
import ua.hillelit.lms.model.Mark;
import ua.hillelit.lms.model.Student;
import ua.hillelit.lms.repository.markRepository.MarkJpaRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * {@link MarkService}
 *
 * @author Dmytro Trotsenko on 1/24/23
 */

@Service
@RequiredArgsConstructor
public class MarkService {

    private final MarkJpaRepository markJpaRepository;
    private final StudentService studentService;
    private final ObjectMapper objectMapper;

    /**
     * Add new entity {@link Mark} and save row with data in database
     *
     * @param studentId  student id
     * @param discipline discipline
     * @param value      value
     * @return {@link MarkDto}
     */
    public MarkDto addMark(Integer studentId, String discipline, Integer value) {

        var markModel = new Mark();
        markModel.setDiscipline(discipline);
        markModel.setValue(value);
        var studentDto = studentService.findStudentById(studentId);
        markModel.setStudent(objectMapper.convertValue(studentDto, Student.class));
        markJpaRepository.save(markModel);
        return objectMapper.convertValue(markModel, MarkDto.class);
    }

    /**
     * Add list of new entity {@link List<MarkDto>} and save row with data in database.
     *
     * @param studentId student id
     * @param marks     {@link List<MarkDto>}
     */
    public void addAllMarks(Integer studentId, List<MarkDto> marks) {
        for (MarkDto mark : marks) {
            addMark(studentId, mark.getDiscipline(), mark.getValue());
        }
    }

    /**
     * Update mark value by student Id and discipline
     *
     * @param id         student id
     * @param discipline student discipline
     * @param value      student mark value
     */
    public void updateMarkValueByStudentIdAndDiscipline(Integer id, String discipline, Integer value) {

        markJpaRepository.updateMarkValueByStudentIdAndDiscipline(id, discipline, value);
    }

    /**
     * Remove mark info from database
     *
     * @param id mark id
     */
    public void removeMark(Integer id) {
        markJpaRepository.removeMark(id);
    }

    /**
     * Find the mark by id.
     *
     * @param id mark id
     * @return {@link MarkDto}
     * @throws EntityNotFoundException if mark id wasn't found
     */
    @SneakyThrows
    public MarkDto findMarkById(Integer id) {
        var mark = markJpaRepository.findMarkById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with id=" + id + " wasn't found"));
        return objectMapper.convertValue(mark, MarkDto.class);
    }

    /**
     * Find all marks from database.
     *
     * @return all marks
     */
    public List<MarkDto> findAllMarks() {
        List<Mark> marks = markJpaRepository.findAllMarks();
        return marks.stream()
                .map(s -> objectMapper.convertValue(s, MarkDto.class))
                .collect(toList());
    }

}
