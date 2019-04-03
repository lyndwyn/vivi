package ch.zhaw.vivi.webContext.domain.answer;

import org.springframework.stereotype.Service;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;

/**
 * This class implements the service-interface which holds all data access related methods targeted towards the
 * entity answer.
 * 
 * @author Yves Kaufmann
 *
 */
@Service
public class ResponseOptionServiceImpl extends ExtendedServiceImpl<ResponseOption> implements ResponseOptionService {
	
	/**
	 * 
	 * @param repository
	 */
	public  ResponseOptionServiceImpl(ResponseOptionRepository repository) {
		super(repository);
	}
	
}
