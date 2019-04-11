package ch.zhaw.vivi.webContext.domain.responseOption;

import org.springframework.stereotype.Repository;

import ch.zhaw.vivi.config.generic.ExtendedJpaRepository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity user.
 *
 * @author Yves Kaufmann
 */
@Repository
public interface ResponseOptionRepository extends ExtendedJpaRepository<ResponseOption> {
	
}
