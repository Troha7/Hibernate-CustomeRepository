package ua.hillelit.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link StudentDto} is a student data class.
 *
 * @author Dmytro Trotsenko on 1/21/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Integer id;

    private String name;

    private String email;


}
