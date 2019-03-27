package ch.zhaw.vivi.webContext.domain.exam;

import org.springframework.stereotype.Repository;

import ch.zhaw.vivi.config.generic.ExtendedJpaRepository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity exam.
 *
 * @author Yves Kaufmann
@Repository
public interface ExamRepository extends ExtendedJpaRepository<Exam> {
	
}
