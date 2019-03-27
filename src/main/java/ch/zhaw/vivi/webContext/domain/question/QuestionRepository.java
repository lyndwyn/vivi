package ch.zhaw.vivi.webContext.domain.question;

import org.springframework.stereotype.Repository;

import ch.zhaw.vivi.config.generic.ExtendedJpaRepository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity question.
 *
 * @author Yves Kaufmann
 */
@Repository
public interface QuestionRepository extends ExtendedJpaRepository<Question> {
	
}
