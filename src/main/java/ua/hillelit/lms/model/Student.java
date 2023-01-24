package ua.hillelit.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * {@link Student} is a student entity class.
 *
 * @author Dmytro Trotsenko on 1/21/23
 */

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(schema = "student_rating")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Mark> marks;

}
