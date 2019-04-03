package ch.zhaw.vivi.webContext.domain.authority;

import org.springframework.stereotype.Service;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;



/**
 * This class implements all data access related methods targeted towards the
 * entity authority.
 * 
 * @author Yves Kaufmann
 */
@Service
public class AuthorityServiceImpl extends ExtendedServiceImpl<Authority> implements AuthorityService {
	/**
	 * TODO comment
	 * @param repository
	 */
	public AuthorityServiceImpl(AuthorityRepository repository) {
		super(repository);
	}

}
