package ch.zhaw.vivi.webContext.domain.authority;

import org.springframework.stereotype.Repository;

import ch.zhaw.vivi.config.generic.ExtendedJpaRepository;



/**
 * This interface holds all data access related methods targeted towards the
 * entity authority.
 * 
 * @author Yves Kaufmann
 */
@Repository
public interface AuthorityRepository extends ExtendedJpaRepository<Authority> {

}
