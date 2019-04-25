package ch.zhaw.vivi.webContext.domain.givenResponse;

import org.springframework.stereotype.Repository;

import ch.zhaw.vivi.config.generic.ExtendedJpaRepository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity GivenResponse.
 *
 */
@Repository
public interface GivenResponseRepository extends ExtendedJpaRepository<GivenResponse> {

}