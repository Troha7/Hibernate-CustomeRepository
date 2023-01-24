package ua.hillelit.lms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * {@link Mark} is a mark entity class.
 *
 * @author Dmytro Trotsenko on 1/21/23
 */

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "student_rating")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_student_id", nullable = false)
    private Student student;

    @Column
    private String discipline;

    @Column
    private Integer value;

}
