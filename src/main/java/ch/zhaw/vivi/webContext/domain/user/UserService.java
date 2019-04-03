package ch.zhaw.vivi.webContext.domain.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import ch.zhaw.vivi.config.generic.ExtendedService;



/**
 * This interface holds all data access related methods targeted towards the
 * entity user.
 * 
 * @author Yves Kaufmann
 *
 */
public interface UserService extends UserDetailsService, ExtendedService<User> {
	
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
