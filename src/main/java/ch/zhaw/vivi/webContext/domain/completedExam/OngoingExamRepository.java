package ch.zhaw.vivi.webContext.domain.completedExam;

import ch.zhaw.vivi.config.generic.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity completedExam.
 *
 * @author Yves Kaufmann
 */
@Repository
public interface OngoingExamRepository extends ExtendedJpaRepository<OngoingExam> {
	
}
