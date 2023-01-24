package ua.hillelit.lms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.hillelit.lms.dto.StudentDto;
import ua.hillelit.lms.service.MarkService;
import ua.hillelit.lms.service.StudentService;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class StudentRatingApp {

    private final StudentService studentService;
    private final MarkService markService;


    public static void main(String[] args) {
        SpringApplication.run(StudentRatingApp.class, args);
    }

    /**
     * Run application after all initialization steps.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        var dto = new StudentDto(null, "Andriy", "and@gmail");
        studentService.createStudent(dto);

        markService.addMark(dto.getId(), "maths", 3);
        markService.addMark(dto.getId(), "physics", 3);

        studentService.updateStudentById(110, "Dima", "d@gmail.com");
        markService.updateMarkValueByStudentIdAndDiscipline(110, "maths", 5);
        markService.updateMarkValueByStudentIdAndDiscipline(110, "physics", 5);

        studentService.removeStudent(109);

        log.info("Find student by ID {}", studentService.findStudentById(110));
        log.info("Find mark by ID {}", markService.findMarkById(125));

        log.info("Find all students {}", studentService.findAllStudents());
        log.info("Find all marks {}", markService.findAllMarks());
    }

}
