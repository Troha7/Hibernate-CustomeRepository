package ua.hillelit.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link MarkDto} is a mark data class.
 *
 * @author Dmytro Trotsenko on 1/21/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {

    private Integer id;

    private StudentDto student;

    private String discipline;

    private Integer value;

}
