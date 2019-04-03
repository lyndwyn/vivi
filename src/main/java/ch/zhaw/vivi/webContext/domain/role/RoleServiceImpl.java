package ch.zhaw.vivi.webContext.domain.role;

import org.springframework.stereotype.Service;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;




/**
 * This class implements all data access related methods targeted towards the
 * entity role.
 * 
 * @author Yves Kaufmann
 *
 */
@Service
public class RoleServiceImpl extends ExtendedServiceImpl<Role> implements RoleService {

	/**
	 * 
	 * @param repository
	 */
	public RoleServiceImpl(RoleRepository repository) {
		super(repository);
	}

}
