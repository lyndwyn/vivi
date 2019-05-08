package ch.zhaw.vivi.webContext.domain.ongoingExam;

import ch.zhaw.vivi.config.generic.ExtendedJpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * This interface holds all data access related methods targeted towards the
 * entity ongoingExam.
 *
 * @author Yves Kaufmann
 */
@Repository
public interface OngoingExamRepository extends ExtendedJpaRepository<OngoingExam> {
	
	// Get average score for each exam 
	@Query(nativeQuery = true, value = "SELECT o.exam_id, AVG(o.score) FROM ongoing_exam o GROUP BY o.exam_id")
	public List<Object> getAverageScore();
	
}
