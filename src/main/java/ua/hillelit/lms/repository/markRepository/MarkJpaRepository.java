package ua.hillelit.lms.repository.markRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.hillelit.lms.model.Mark;

/**
 * {@link MarkJpaRepository}
 *
 * @author Dmytro Trotsenko on 1/21/23
 */

@Repository
public interface MarkJpaRepository extends JpaRepository<Mark,Integer>, CustomMarkRepository{

}
