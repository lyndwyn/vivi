package ch.zhaw.vivi.webContext.domain.user;

import org.springframework.stereotype.Repository;

import ch.zhaw.vivi.config.generic.ExtendedJpaRepository;



/**
 * This interface holds all data access related methods targeted towards the
 * entity user.
 *
 * @author Yves Kaufmann
 */
@Repository
interface UserRepository extends ExtendedJpaRepository<User> {
	
	/**
	 * This method finds a User with a given name
	 *
	 * @param  name Descriptive name of User
	 * @return      Returns requested User with given descriptive name of User
	 */
	User findByUsername(String name);
	
	/**
	 * This method deletes the requested User with a given name
	 *
	 * @param name Descriptive name of User
	 */
	void deleteByUsername(String name);
}
