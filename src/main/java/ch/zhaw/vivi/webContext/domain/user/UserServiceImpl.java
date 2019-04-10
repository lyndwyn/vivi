package ch.zhaw.vivi.webContext.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;




/**
 * This class implements all data access related methods targeted towards the
 * entity role.
 * 
 * @author Yves Kaufmann
 */
@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService {

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * @param repository
	 */
	@Autowired
	UserServiceImpl(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super(repository);
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUsername(username);

		if (user == null) { throw new UsernameNotFoundException("User could not be found"); }
		return new UserDetailsImpl(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findByUsername(String name) {
		User user = ((UserRepository) repository).findByUsername(name);
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteByUsername(String name) {
		((UserRepository) repository).deleteByUsername(name);
	}

}
