package ch.zhaw.vivi.webContext.domain.role;

import org.springframework.stereotype.Repository;

import ch.zhaw.vivi.config.generic.ExtendedJpaRepository;



/**
 * This interface holds all data access related methods targeted towards the
 * entity role.
 * 
 * @author Yves Kaufmann
 *
 */
@Repository
public interface RoleRepository extends ExtendedJpaRepository<Role> {

}
