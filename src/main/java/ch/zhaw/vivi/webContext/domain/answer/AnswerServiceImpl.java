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
public class AnswerServiceImpl extends ExtendedServiceImpl<Answer> implements AnswerService {
	
	/**
	 * 
	 * @param repository
	 */
	public AnswerServiceImpl(AnswerRepository repository) {
		super(repository);
	}
	
}
